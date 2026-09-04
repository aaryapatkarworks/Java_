import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class _01_JDBC_Connection {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/jdbc_demo";
        String username = "root";
        String password = "AP21";

        try {
            Connection connection =
                    DriverManager.getConnection(url, username, password);

            System.out.println("Database connection successful!");

            connection.close();

        } catch (SQLException e) {
            System.out.println("Database connection failed!");
            e.printStackTrace();
        }
    }
}