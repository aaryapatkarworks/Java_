import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class _07_BatchProcessing {

    public static void main(String[] args) {

        String url =
                "jdbc:mysql://localhost:3306/jdbc_demo";

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

            // Employee 1
            statement.setInt(1, 5);
            statement.setString(2, "Siddhi Chaudhary");
            statement.setString(3, "CMA");
            statement.setDouble(4, 64000);

            statement.addBatch();

            // Employee 2
            statement.setInt(1, 6);
            statement.setString(2, "Nikhil Deshmukh");
            statement.setString(3, "Backend Engineering");
            statement.setDouble(4, 70000);

            statement.addBatch();

            // Employee 3
            statement.setInt(1, 7);
            statement.setString(2, "Srushti Nikte");
            statement.setString(3, "HR");
            statement.setDouble(4, 60000);

            statement.addBatch();

            int[] results =
                    statement.executeBatch();

            System.out.println(
                    "Batch executed successfully."
            );

            System.out.println(
                    "Operations executed: "
                            + results.length
            );

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}