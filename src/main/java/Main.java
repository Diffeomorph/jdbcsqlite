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

    public static void main(String[] args){
        //createNewDatabase("test.db");
        createNewTable();
    }
}
