import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

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

    public static void main(String[] args){
        createNewDatabase("test.db");
    }
}
