import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class _03_PreparedStatement {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/jdbc_demo";
        String username = "root";
        String password = "AP21";

        String sql =
                "INSERT INTO employees " +
                        "(id, name, department, salary) " +
                        "VALUES (?, ?, ?, ?)";

        try (
                Connection connection =
                        DriverManager.getConnection(
                                url,
                                username,
                                password
                        );

                PreparedStatement statement =
                        connection.prepareStatement(sql)
        ) {

            statement.setInt(1, 2);
            statement.setString(2, "Pranav More");
            statement.setString(3, "CSE- AI & Business");
            statement.setDouble(4, 90000);

            statement.executeUpdate();

            statement.setInt(1, 3);
            statement.setString(2, "Arnav Jadhav");
            statement.setString(3, "AI-DS");
            statement.setDouble(4, 65000);

            statement.executeUpdate();

            statement.setInt(1, 4);
            statement.setString(2, "Pratiksha Kulkarni");
            statement.setString(3, "Electrical Engineering");
            statement.setDouble(4, 60000);

            int rowsAffected =
                    statement.executeUpdate();
;
            System.out.println(
                    "Rows inserted: " + rowsAffected
            );

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}