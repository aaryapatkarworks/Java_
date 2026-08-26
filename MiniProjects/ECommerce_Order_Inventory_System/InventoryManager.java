import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class InventoryManager {

    private List<Product> inventory;
    private final int LOW_STOCK_LIMIT = 10;

    public InventoryManager() {
        inventory = new ArrayList<>();
    }

    // Add a product to inventory
    public void addProduct(Product product) {

        if (product == null) {
            throw new IllegalArgumentException(
                    "Product cannot be null."
            );
        }

        inventory.add(product);
    }

    // Check stock of a product
    public int getStock(String productId) {

        for (Product product : inventory) {

            if (product.getProductId().equals(productId)) {
                return product.getStockQuantity();
            }
        }

        return -1;
    }

    // Restock a product
    public boolean restockProduct(
            String productId,
            int quantity
    ) {

        for (Product product : inventory) {

            if (product.getProductId().equals(productId)) {

                product.increaseStock(quantity);
                return true;
            }
        }

        return false;
    }

    // Reduce stock when an order is placed
    public boolean reduceStock(
            String productId,
            int quantity
    ) {

        for (Product product : inventory) {

            if (product.getProductId().equals(productId)) {

                return product.decreaseStock(quantity);
            }
        }

        return false;
    }

    // Find products below the low-stock limit
    public List<Product> getLowStockProducts() {

        List<Product> lowStockProducts =
                new ArrayList<>();

        for (Product product : inventory) {

            if (product.getStockQuantity()
                    <= LOW_STOCK_LIMIT) {

                lowStockProducts.add(product);
            }
        }

        return lowStockProducts;
    }

    // Find the product with the highest stock
    public Product getHighestStockProduct() {

        if (inventory.isEmpty()) {
            return null;
        }

        return inventory.stream()
                .max(
                        Comparator.comparingInt(
                                Product::getStockQuantity
                        )
                )
                .orElse(null);
    }

    // Find the product with the lowest stock
    public Product getLowestStockProduct() {

        if (inventory.isEmpty()) {
            return null;
        }

        return inventory.stream()
                .min(
                        Comparator.comparingInt(
                                Product::getStockQuantity
                        )
                )
                .orElse(null);
    }

    // Display complete inventory
    public void displayInventory() {

        for (Product product : inventory) {
            System.out.println(
                    product.getProductId()
                            + " | "
                            + product.getName()
                            + " | Stock: "
                            + product.getStockQuantity()
            );
        }
    }

    // Sort inventory by stock - lowest first
    public List<Product> sortByStockAscending() {

        List<Product> sortedInventory =
                new ArrayList<>(inventory);

        sortedInventory.sort(
                Comparator.comparingInt(
                        Product::getStockQuantity
                )
        );

        return sortedInventory;
    }

    // Remove products with zero stock
    public void removeOutOfStockProducts() {

        Iterator<Product> iterator =
                inventory.iterator();

        while (iterator.hasNext()) {

            Product product = iterator.next();

            if (product.getStockQuantity() == 0) {
                iterator.remove();
            }
        }
    }

    public int getInventorySize() {
        return inventory.size();
    }
}