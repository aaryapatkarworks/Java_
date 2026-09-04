import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class _04_ResultSet {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/jdbc_demo";
        String username = "root";
        String password = "AP21";

        String sql = "SELECT * FROM employees";

        try (
                Connection connection =
                        DriverManager.getConnection(
                                url,
                                username,
                                password
                        );

                PreparedStatement statement =
                        connection.prepareStatement(sql);

                ResultSet resultSet =
                        statement.executeQuery()
        ) {

            while (resultSet.next()) {

                int id =
                        resultSet.getInt("id");

                String name =
                        resultSet.getString("name");

                String department =
                        resultSet.getString("department");

                double salary =
                        resultSet.getDouble("salary");

                System.out.println(
                        id + " | " +
                                name + " | " +
                                department + " | " +
                                salary
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}