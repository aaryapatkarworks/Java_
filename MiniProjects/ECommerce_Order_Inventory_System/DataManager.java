import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class DataManager {

    private static final String PRODUCT_FILE =
            "products.txt";

    public static void saveProducts(
            ProductCatalog catalog
    ) {

        try (
                BufferedWriter writer =
                        new BufferedWriter(
                                new FileWriter(PRODUCT_FILE)
                        )
        ) {

            for (Product product :
                    catalog.getAllProducts()) {

                writer.write(
                        product.getProductId()
                                + "|"
                                + product.getName()
                                + "|"
                                + product.getCategory()
                                + "|"
                                + product.getPrice()
                                + "|"
                                + product.getStockQuantity()
                                + "|"
                                + product.getRating()
                );

                writer.newLine();
            }

            System.out.println(
                    "Product data saved successfully."
            );

        } catch (IOException e) {

            System.out.println(
                    "Unable to save product data: "
                            + e.getMessage()
            );
        }
    }

    public static void loadProducts(
            ProductCatalog catalog,
            InventoryManager inventory
    ) {

        try (
                BufferedReader reader =
                        new BufferedReader(
                                new FileReader(PRODUCT_FILE)
                        )
        ) {

            String line;

            while ((line = reader.readLine()) != null) {

                if (line.isBlank()) {
                    continue;
                }

                String[] data =
                        line.split("\\|");

                if (data.length != 6) {
                    continue;
                }

                try {

                    String productId = data[0];
                    String name = data[1];
                    String category = data[2];

                    double price =
                            Double.parseDouble(data[3]);

                    int stock =
                            Integer.parseInt(data[4]);

                    double rating =
                            Double.parseDouble(data[5]);

                    Product product =
                            new Product(
                                    productId,
                                    name,
                                    category,
                                    price,
                                    stock,
                                    rating
                            );

                    catalog.addProduct(product);

                    inventory.addProduct(product);

                } catch (NumberFormatException e) {

                    System.out.println(
                            "Invalid product data skipped."
                    );
                }
            }

            System.out.println(
                    "Product data loaded successfully."
            );

        } catch (IOException e) {

            System.out.println(
                    "No existing product data found."
            );
        }
    }
}