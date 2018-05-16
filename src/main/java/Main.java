import java.sql.*;

public class Main {
    public static void createNewDatabase(String fileName){
        String url = "jdbc:sqlite:C:/sqlite/db/"+fileName;

        try (Connection conn = DriverManager.getConnection(url)){
            if (conn != null){
                DatabaseMetaData meta = conn.getMetaData();
                System.out.println("The driver name is "+meta.getDriverName());

            }
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public static void createNewTable(){
        String url = "jdbc:sqlite:C://sqlite/db/tests.db";

        String sql = "CREATE TABLE IF NOT EXISTS warehouses (\n"
                + "	id integer PRIMARY KEY,\n"
                + "	name text NOT NULL,\n"
                + "	capacity real\n"
                + ");";

        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {
            // create a new table
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private Connection connect() {
        // SQLite connection string
        String url = "jdbc:sqlite:C://sqlite/db/test.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public void insert(String name, double capacity){
        String sql = "INSERT INTO warehouses(name,capacity) VALUES(?,?)";

        try (Connection conn = this.connect();PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setString(1,name);
            pstmt.setDouble(2,capacity);
            pstmt.executeUpdate();
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args){
        //createNewDatabase("test.db");
        //createNewTable();
        Main app = new Main();
        app.insert("Raw Materials",3000);
        app.insert("Semifinished Goods",4000);
        app.insert("Finished Goods",5000);
    }
}
