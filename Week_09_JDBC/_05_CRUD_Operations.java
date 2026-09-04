import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class _05_CRUD_Operations {

    private static final String URL =
            "jdbc:mysql://localhost:3306/jdbc_demo";

    private static final String USERNAME =
            "root";

    private static final String PASSWORD =
            "AP21";

    public static void main(String[] args) {

        createEmployee(
                5,
                "Siddhi Chaudhary",
                "CMA",
                64000
        );

        getEmployees();

        updateEmployeeSalary(1, 95000);

        getEmployees();

        deleteEmployee(5);

        getEmployees();
    }

    // CREATE
    public static void createEmployee(
            int id,
            String name,
            String department,
            double salary
    ) {

        String sql =
                "INSERT INTO employees " +
                        "(id, name, department, salary) " +
                        "VALUES (?, ?, ?, ?)";

        try (
                Connection connection =
                        DriverManager.getConnection(
                                URL,
                                USERNAME,
                                PASSWORD
                        );

                PreparedStatement statement =
                        connection.prepareStatement(sql)
        ) {

            statement.setInt(1, id);
            statement.setString(2, name);
            statement.setString(3, department);
            statement.setDouble(4, salary);

            int rows =
                    statement.executeUpdate();

            System.out.println(
                    "Employees created: " + rows
            );

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // READ
    public static void getEmployees() {

        String sql =
                "SELECT * FROM employees";

        try (
                Connection connection =
                        DriverManager.getConnection(
                                URL,
                                USERNAME,
                                PASSWORD
                        );

                PreparedStatement statement =
                        connection.prepareStatement(sql);

                ResultSet resultSet =
                        statement.executeQuery()
        ) {

            System.out.println(
                    "\n--- Employees ---"
            );

            while (resultSet.next()) {

                System.out.println(
                        resultSet.getInt("id")
                                + " | " +
                                resultSet.getString("name")
                                + " | " +
                                resultSet.getString("department")
                                + " | " +
                                resultSet.getDouble("salary")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // UPDATE
    public static void updateEmployeeSalary(
            int id,
            double newSalary
    ) {

        String sql =
                "UPDATE employees " +
                        "SET salary = ? " +
                        "WHERE id = ?";

        try (
                Connection connection =
                        DriverManager.getConnection(
                                URL,
                                USERNAME,
                                PASSWORD
                        );

                PreparedStatement statement =
                        connection.prepareStatement(sql)
        ) {

            statement.setDouble(1, newSalary);
            statement.setInt(2, id);

            int rows =
                    statement.executeUpdate();

            System.out.println(
                    "\nEmployees updated: " + rows
            );

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // DELETE
    public static void deleteEmployee(int id) {

        String sql =
                "DELETE FROM employees " +
                        "WHERE id = ?";

        try (
                Connection connection =
                        DriverManager.getConnection(
                                URL,
                                USERNAME,
                                PASSWORD
                        );

                PreparedStatement statement =
                        connection.prepareStatement(sql)
        ) {

            statement.setInt(1, id);

            int rows =
                    statement.executeUpdate();

            System.out.println(
                    "\nEmployees deleted: " + rows
            );

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}