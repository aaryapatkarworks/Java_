import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class _08_JDBC_ExceptionHandling {

    private static final String URL =
            "jdbc:mysql://localhost:3306/jdbc_demowrong";// wrong database name

    private static final String USERNAME = "root";
    private static final String PASSWORD = "AP21";

    public static void main(String[] args) {

        try {
            Connection connection =
                    DriverManager.getConnection(URL, USERNAME, PASSWORD);

            System.out.println("Database connected successfully.");

            connection.close();

        } catch (SQLException e) {

            System.out.println("Database operation failed.");
            System.out.println("Message: " + e.getMessage());
            System.out.println("SQL State: " + e.getSQLState());
            System.out.println("Error Code: " + e.getErrorCode());
        }
    }
}