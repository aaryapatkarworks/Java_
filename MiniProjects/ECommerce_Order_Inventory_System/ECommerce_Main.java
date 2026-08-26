import java.util.List;
import java.util.Scanner;

public class ECommerce_Main {

    private static final Scanner scanner =
            new Scanner(System.in);

    private static final ProductCatalog catalog =
            new ProductCatalog();

    private static final InventoryManager inventory =
            new InventoryManager();

    private static final OrderManager orderManager =
            new OrderManager(
                    catalog,
                    inventory
            );

    public static void main(String[] args) {

        DataManager.loadProducts(
                catalog,
                inventory
        );

        boolean running = true;

        System.out.println(
                "========================================"
        );

        System.out.println(
                "     E-COMMERCE ORDER & INVENTORY"
        );

        System.out.println(
                "========================================"
        );

        while (running) {

            displayMenu();

            int choice =
                    readInt("Enter your choice: ");

            System.out.println();

            switch (choice) {

                case 1:
                    addProduct();
                    break;

                case 2:
                    displayProducts();
                    break;

                case 3:
                    searchProduct();
                    break;

                case 4:
                    restockProduct();
                    break;

                case 5:
                    createOrder();
                    break;

                case 6:
                    displayOrders();
                    break;

                case 7:
                    processNextOrder();
                    break;

                case 8:
                    inventoryReport();
                    break;

                case 9:
                    productReports();
                    break;

                case 10:

                    DataManager.saveProducts(
                            catalog
                    );

                    running = false;

                    System.out.println(
                            "Thank you for using the system."
                    );

                    break;

                default:

                    System.out.println(
                            "Invalid choice. Please try again."
                    );
            }
        }

        scanner.close();
    }

    private static void displayMenu() {

        System.out.println(
                "\n========== MAIN MENU =========="
        );

        System.out.println(
                "1. Add Product"
        );

        System.out.println(
                "2. View Products"
        );

        System.out.println(
                "3. Search Product"
        );

        System.out.println(
                "4. Restock Product"
        );

        System.out.println(
                "5. Create Order"
        );

        System.out.println(
                "6. View Orders"
        );

        System.out.println(
                "7. Process Next Order"
        );

        System.out.println(
                "8. Inventory Report"
        );

        System.out.println(
                "9. Product Reports"
        );

        System.out.println(
                "10. Exit"
        );
    }

    private static void addProduct() {

        System.out.println(
                "========== ADD PRODUCT =========="
        );

        String productId =
                readString("Product ID: ");

        if (catalog.findProductById(productId) != null) {

            System.out.println(
                    "Product ID already exists."
            );

            return;
        }

        String name =
                readString("Product Name: ");

        String category =
                readString("Category: ");

        double price =
                readDouble("Price: ₹");

        int stock =
                readInt("Initial Stock: ");

        double rating =
                readDouble("Rating: ");

        if (price < 0) {

            System.out.println(
                    "Price cannot be negative."
            );

            return;
        }

        if (stock < 0) {

            System.out.println(
                    "Stock cannot be negative."
            );

            return;
        }

        if (rating < 0 || rating > 5) {

            System.out.println(
                    "Rating must be between 0 and 5."
            );

            return;
        }

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

        System.out.println(
                "Product added successfully."
        );
    }

    private static void displayProducts() {

        System.out.println(
                "========== PRODUCT CATALOG =========="
        );

        if (catalog.getProductCount() == 0) {

            System.out.println(
                    "No products available."
            );

            return;
        }

        catalog.displayAllProducts();
    }

    private static void searchProduct() {

        String productId =
                readString("Enter Product ID: ");

        Product product =
                catalog.findProductById(productId);

        if (product == null) {

            System.out.println(
                    "Product not found."
            );

            return;
        }

        System.out.println(
                "\nProduct Found:"
        );

        System.out.println(product);
    }

    private static void restockProduct() {

        String productId =
                readString("Enter Product ID: ");

        if (catalog.findProductById(productId) == null) {

            System.out.println(
                    "Product not found."
            );

            return;
        }

        int quantity =
                readInt("Quantity to add: ");

        if (quantity <= 0) {

            System.out.println(
                    "Quantity must be greater than zero."
            );

            return;
        }

        boolean success =
                inventory.restockProduct(
                        productId,
                        quantity
                );

        if (success) {

            System.out.println(
                    "Stock updated successfully."
            );

            System.out.println(
                    "New Stock: "
                            + inventory.getStock(productId)
            );
        }
    }

    private static void createOrder() {

        System.out.println(
                "========== CREATE ORDER =========="
        );

        String orderId =
                readString("Order ID: ");

        if (orderManager.findOrderById(orderId) != null) {

            System.out.println(
                    "Order ID already exists."
            );

            return;
        }

        String customerName =
                readString("Customer Name: ");

        System.out.println(
                "\nSelect Priority:"
        );

        System.out.println(
                "1. LOW"
        );

        System.out.println(
                "2. MEDIUM"
        );

        System.out.println(
                "3. HIGH"
        );

        System.out.println(
                "4. CRITICAL"
        );

        int priorityChoice =
                readInt("Enter priority: ");

        EcommerceOrder.Priority priority =
                getPriority(priorityChoice);

        if (priority == null) {

            System.out.println(
                    "Invalid priority."
            );

            return;
        }

        EcommerceOrder order =
                new EcommerceOrder(
                        orderId,
                        customerName,
                        priority
                );

        boolean addingItems = true;

        while (addingItems) {

            System.out.println(
                    "\nAvailable Products:"
            );

            catalog.displayAllProducts();

            String productId =
                    readString(
                            "\nEnter Product ID "
                                    + "(or DONE): "
                    );

            if (productId.equalsIgnoreCase("DONE")) {

                addingItems = false;
                continue;
            }

            Product product =
                    catalog.findProductById(productId);

            if (product == null) {

                System.out.println(
                        "Product not found."
                );

                continue;
            }

            int quantity =
                    readInt("Quantity: ");

            if (quantity <= 0) {

                System.out.println(
                        "Quantity must be greater than zero."
                );

                continue;
            }

            int availableStock =
                    inventory.getStock(productId);

            if (quantity > availableStock) {

                System.out.println(
                        "Insufficient stock."
                );

                System.out.println(
                        "Available stock: "
                                + availableStock
                );

                continue;
            }

            order.addItem(
                    new OrderItem(
                            product,
                            quantity
                    )
            );

            System.out.println(
                    "Product added to order."
            );
        }

        if (order.getItems().isEmpty()) {

            System.out.println(
                    "Order cancelled. No items added."
            );

            return;
        }

        try {

            orderManager.createOrder(order);

            System.out.println(
                    "\nOrder created successfully."
            );

            System.out.println(
                    "Order Total: ₹"
                            + order.calculateTotal()
            );

        } catch (IllegalArgumentException e) {

            System.out.println(
                    "Unable to create order: "
                            + e.getMessage()
            );
        }
    }

    private static void displayOrders() {

        System.out.println(
                "========== ALL ORDERS =========="
        );

        if (orderManager.getTotalOrders() == 0) {

            System.out.println(
                    "No orders available."
            );

            return;
        }

        orderManager.displayAllOrders();
    }

    private static void processNextOrder() {

        System.out.println(
                "========== PROCESS NEXT ORDER =========="
        );

        EcommerceOrder order =
                orderManager.processNextOrder();

        if (order == null) {

            System.out.println(
                    "No pending orders."
            );

            return;
        }

        System.out.println(
                "Order ID: "
                        + order.getOrderId()
        );

        System.out.println(
                "Customer: "
                        + order.getCustomerName()
        );

        System.out.println(
                "Priority: "
                        + order.getPriority()
        );

        System.out.println(
                "Total: ₹"
                        + order.calculateTotal()
        );

        boolean completed =
                orderManager.completeOrder(
                        order.getOrderId()
                );

        if (completed) {

            System.out.println(
                    "Order completed successfully."
            );
        }
    }

    private static void inventoryReport() {

        System.out.println(
                "========== INVENTORY REPORT =========="
        );

        inventory.displayInventory();

        Product highestStock =
                inventory.getHighestStockProduct();

        Product lowestStock =
                inventory.getLowestStockProduct();

        System.out.println(
                "\nHighest Stock:"
        );

        if (highestStock != null) {
            System.out.println(highestStock);
        }

        System.out.println(
                "\nLowest Stock:"
        );

        if (lowestStock != null) {
            System.out.println(lowestStock);
        }

        System.out.println(
                "\nLow Stock Products:"
        );

        List<Product> lowStock =
                inventory.getLowStockProducts();

        if (lowStock.isEmpty()) {

            System.out.println(
                    "No products are low on stock."
            );

        } else {

            for (Product product : lowStock) {

                System.out.println(
                        product.getName()
                                + " → "
                                + product.getStockQuantity()
                                + " units"
                );
            }
        }
    }

    private static void productReports() {

        System.out.println(
                "========== PRODUCT REPORTS =========="
        );

        System.out.println(
                "\nProducts by Price:"
        );

        for (Product product :
                catalog.sortByPriceAscending()) {

            System.out.println(
                    product.getName()
                            + " → ₹"
                            + product.getPrice()
            );
        }

        System.out.println(
                "\nProducts by Rating:"
        );

        for (Product product :
                catalog.sortByRating()) {

            System.out.println(
                    product.getName()
                            + " → "
                            + product.getRating()
            );
        }

        System.out.println(
                "\nMost Expensive Product:"
        );

        System.out.println(
                catalog.getMostExpensiveProduct()
        );

        System.out.println(
                "\nCheapest Product:"
        );

        System.out.println(
                catalog.getCheapestProduct()
        );
    }

    private static EcommerceOrder.Priority
    getPriority(int choice) {

        switch (choice) {

            case 1:
                return EcommerceOrder.Priority.LOW;

            case 2:
                return EcommerceOrder.Priority.MEDIUM;

            case 3:
                return EcommerceOrder.Priority.HIGH;

            case 4:
                return EcommerceOrder.Priority.CRITICAL;

            default:
                return null;
        }
    }

    private static String readString(String message) {

        System.out.print(message);

        return scanner.nextLine().trim();
    }

    private static int readInt(String message) {

        while (true) {

            try {

                System.out.print(message);

                return Integer.parseInt(
                        scanner.nextLine().trim()
                );

            } catch (NumberFormatException e) {

                System.out.println(
                        "Please enter a valid integer."
                );
            }
        }
    }

    private static double readDouble(String message) {

        while (true) {

            try {

                System.out.print(message);

                return Double.parseDouble(
                        scanner.nextLine().trim()
                );

            } catch (NumberFormatException e) {

                System.out.println(
                        "Please enter a valid number."
                );
            }
        }
    }
}