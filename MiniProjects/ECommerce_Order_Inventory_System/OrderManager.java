import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class OrderManager {

    private Map<String, EcommerceOrder> ordersById;
    private List<EcommerceOrder> orderHistory;
    private PriorityQueue<EcommerceOrder> pendingOrders;

    private ProductCatalog productCatalog;
    private InventoryManager inventoryManager;

    public OrderManager(
            ProductCatalog productCatalog,
            InventoryManager inventoryManager
    ) {
        this.productCatalog = productCatalog;
        this.inventoryManager = inventoryManager;

        ordersById = new HashMap<>();
        orderHistory = new ArrayList<>();
        pendingOrders = new PriorityQueue<>();
    }

    // Create and register an order
    public void createOrder(EcommerceOrder order) {

        if (order == null) {
            throw new IllegalArgumentException(
                    "Order cannot be null."
            );
        }

        if (ordersById.containsKey(order.getOrderId())) {
            throw new IllegalArgumentException(
                    "Order ID already exists: "
                            + order.getOrderId()
            );
        }

        validateStock(order);

        reserveStock(order);

        ordersById.put(
                order.getOrderId(),
                order
        );

        orderHistory.add(order);

        pendingOrders.offer(order);
    }

    // Check whether all ordered products are available
    private void validateStock(EcommerceOrder order) {

        for (OrderItem item : order.getItems()) {

            String productId =
                    item.getProduct().getProductId();

            int availableStock =
                    inventoryManager.getStock(productId);

            if (availableStock == -1) {
                throw new IllegalArgumentException(
                        "Product not found in inventory: "
                                + productId
                );
            }

            if (item.getQuantity() > availableStock) {
                throw new IllegalArgumentException(
                        "Insufficient stock for: "
                                + item.getProduct().getName()
                );
            }
        }
    }

    // Deduct stock after successful validation
    private void reserveStock(EcommerceOrder order) {

        for (OrderItem item : order.getItems()) {

            inventoryManager.reduceStock(
                    item.getProduct().getProductId(),
                    item.getQuantity()
            );
        }
    }

    // Find order by ID
    public EcommerceOrder findOrderById(String orderId) {

        return ordersById.get(orderId);
    }

    // Process the highest-priority pending order
    public EcommerceOrder processNextOrder() {

        EcommerceOrder order =
                pendingOrders.poll();

        if (order == null) {
            return null;
        }

        order.setStatus(
                EcommerceOrder.Status.PROCESSING
        );

        System.out.println(
                "Processing Order: "
                        + order.getOrderId()
        );

        return order;
    }

    // Complete an order
    public boolean completeOrder(String orderId) {

        EcommerceOrder order =
                ordersById.get(orderId);

        if (order == null) {
            return false;
        }

        if (order.getStatus()
                != EcommerceOrder.Status.PROCESSING) {

            return false;
        }

        order.setStatus(
                EcommerceOrder.Status.COMPLETED
        );

        return true;
    }

    // Cancel an order
    public boolean cancelOrder(String orderId) {

        EcommerceOrder order =
                ordersById.get(orderId);

        if (order == null) {
            return false;
        }

        if (order.getStatus()
                == EcommerceOrder.Status.COMPLETED) {

            return false;
        }

        order.setStatus(
                EcommerceOrder.Status.CANCELLED
        );

        return true;
    }

    // Remove cancelled orders from pending queue
    public void removeCancelledOrders() {

        Iterator<EcommerceOrder> iterator =
                pendingOrders.iterator();

        while (iterator.hasNext()) {

            EcommerceOrder order =
                    iterator.next();

            if (order.getStatus()
                    == EcommerceOrder.Status.CANCELLED) {

                iterator.remove();
            }
        }
    }

    // Display all orders
    public void displayAllOrders() {

        for (EcommerceOrder order : orderHistory) {
            System.out.println(order);
        }
    }

    // Display pending orders
    public void displayPendingOrders() {

        for (EcommerceOrder order : pendingOrders) {
            System.out.println(order);
        }
    }

    // Sort completed orders by total amount
    public List<EcommerceOrder> sortOrdersByAmount() {

        List<EcommerceOrder> sortedOrders =
                new ArrayList<>(orderHistory);

        sortedOrders.sort(
                Comparator.comparingDouble(
                        EcommerceOrder::calculateTotal
                ).reversed()
        );

        return sortedOrders;
    }

    public int getTotalOrders() {
        return ordersById.size();
    }

    public int getPendingOrderCount() {
        return pendingOrders.size();
    }
}