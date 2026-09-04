import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class _06_Transaction {

    public static void main(String[] args) {

        String url =
                "jdbc:mysql://localhost:3306/jdbc_demo";

        String username = "root";
        String password = "AP21";

        String withdrawSQL =
                "UPDATE accounts " +
                        "SET balance = balance - ? " +
                        "WHERE id = ?";

        String depositSQL =
                "UPDATE accounts " +
                        "SET balance = balance + ? " +
                        "WHERE id = ?";

        try (
                Connection connection =
                        DriverManager.getConnection(
                                url,
                                username,
                                password
                        );

                PreparedStatement withdraw =
                        connection.prepareStatement(
                                withdrawSQL
                        );

                PreparedStatement deposit =
                        connection.prepareStatement(
                                depositSQL
                        )
        ) {

            // Disable auto-commit
            connection.setAutoCommit(false);

            try {

                // Withdraw from Pranav
                withdraw.setDouble(1, 8000);
                withdraw.setInt(2, 2);
                withdraw.executeUpdate();

                // Deposit to Aarya
                deposit.setDouble(1, 8000);
                deposit.setInt(2, 1);
                deposit.executeUpdate();

                // Make both changes permanent
                connection.commit();

                System.out.println(
                        "Transaction successful."
                );

            } catch (SQLException e) {

                connection.rollback();

                System.out.println(
                        "Transaction failed. Rolled back."
                );

            }

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }
}