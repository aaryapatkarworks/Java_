import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class _02_Statement {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/jdbc_demo";
        String username = "root";
        String password = "AP21";

        try {
            Connection connection =
                    DriverManager.getConnection(url, username, password);

            Statement statement = connection.createStatement();

            String sql =
                    "INSERT INTO employees VALUES " +
                            "(1, 'Aarya Patkar', 'CSE- AI & Data Science', 75000)";

            int rowsAffected = statement.executeUpdate(sql);

            System.out.println(
                    "Rows inserted: " + rowsAffected
            );

            statement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}