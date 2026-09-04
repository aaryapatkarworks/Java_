import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductsDAO {

    private static final String URL = "jdbc:mysql://localhost:3306/jdbc_demo";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "AP21";


    // CREATE
    public void addProducts(Products product) {

        String sql = "INSERT INTO products (id, name, category, price) " +
                "VALUES (?, ?, ?, ?)";

        try (Connection connection =
                     DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement preparedStatement =
                     connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, product.getId());
            preparedStatement.setString(2, product.getName());
            preparedStatement.setString(3, product.getCategory());
            preparedStatement.setDouble(4, product.getPrice());

            int rowsAffected = preparedStatement.executeUpdate();

            System.out.println(rowsAffected + " product added successfully.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    // READ - Get all products
    public List<Products> getAllProducts() {

        List<Products> products = new ArrayList<>();

        String sql = "SELECT * FROM products";

        try (Connection connection =
                     DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement preparedStatement =
                     connection.prepareStatement(sql);
             ResultSet resultSet =
                     preparedStatement.executeQuery()) {

            while (resultSet.next()) {

                Products product = new Products(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("category"),
                        resultSet.getDouble("price")
                );

                products.add(product);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return products;
    }


    // READ - Get product by ID
    public Products getProductsById(int id) {

        String sql = "SELECT * FROM products WHERE id = ?";

        try (Connection connection =
                     DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement preparedStatement =
                     connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, id);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {

                if (resultSet.next()) {

                    return new Products(
                            resultSet.getInt("id"),
                            resultSet.getString("name"),
                            resultSet.getString("category"),
                            resultSet.getDouble("price")
                    );
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }


    // UPDATE - Update product price
    public void updateProductPrice(int id, double newPrice) {

        String sql = "UPDATE products SET price = ? WHERE id = ?";

        try (Connection connection =
                     DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement preparedStatement =
                     connection.prepareStatement(sql)) {

            preparedStatement.setDouble(1, newPrice);
            preparedStatement.setInt(2, id);

            int rowsAffected = preparedStatement.executeUpdate();

            System.out.println(rowsAffected + " product updated successfully.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    // DELETE
    public void deleteProducts(int id) {

        String sql = "DELETE FROM products WHERE id = ?";

        try (Connection connection =
                     DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement preparedStatement =
                     connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, id);

            int rowsAffected = preparedStatement.executeUpdate();

            System.out.println(rowsAffected + " product deleted successfully.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}