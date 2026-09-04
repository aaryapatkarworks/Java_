import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class _09_JDBC_MetaData {

    private static final String URL =
            "jdbc:mysql://localhost:3306/jdbc_demo";

    private static final String USERNAME = "root";
    private static final String PASSWORD = "AP21";

    public static void main(String[] args) {

        showDatabaseMetadata();
        showResultSetMetadata();
    }

    private static void showDatabaseMetadata() {

        try (
                Connection connection =
                        DriverManager.getConnection(
                                URL,
                                USERNAME,
                                PASSWORD
                        )
        ) {

            DatabaseMetaData metaData =
                    connection.getMetaData();

            System.out.println("=== DATABASE METADATA ===");

            System.out.println(
                    "Database: "
                            + metaData.getDatabaseProductName()
            );

            System.out.println(
                    "Version: "
                            + metaData.getDatabaseProductVersion()
            );

            System.out.println(
                    "Driver: "
                            + metaData.getDriverName()
            );

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void showResultSetMetadata() {

        String sql = "SELECT * FROM employees";

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

            ResultSetMetaData metaData =
                    resultSet.getMetaData();

            int columnCount =
                    metaData.getColumnCount();

            System.out.println(
                    "\n=== RESULT SET METADATA ==="
            );

            System.out.println(
                    "Number of columns: " + columnCount
            );

            for (int i = 1; i <= columnCount; i++) {

                System.out.println(
                        "Column " + i
                                + ": "
                                + metaData.getColumnName(i)
                                + " | Type: "
                                + metaData.getColumnTypeName(i)
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}