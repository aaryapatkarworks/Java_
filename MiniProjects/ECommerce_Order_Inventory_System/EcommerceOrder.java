import java.util.ArrayList;
import java.util.List;

public class EcommerceOrder implements Comparable<EcommerceOrder> {

    public enum Priority {
        LOW,
        MEDIUM,
        HIGH,
        CRITICAL
    }

    public enum Status {
        PENDING,
        PROCESSING,
        COMPLETED,
        CANCELLED
    }

    private String orderId;
    private String customerName;
    private List<OrderItem> items;
    private Priority priority;
    private Status status;

    public EcommerceOrder(
            String orderId,
            String customerName,
            Priority priority
    ) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.priority = priority;
        this.status = Status.PENDING;
        this.items = new ArrayList<>();
    }

    public void addItem(OrderItem item) {
        items.add(item);
    }

    public double calculateTotal() {

        double total = 0;

        for (OrderItem item : items) {
            total += item.getSubtotal();
        }

        return total;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public Priority getPriority() {
        return priority;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    // Natural ordering: CRITICAL → HIGH → MEDIUM → LOW
    @Override
    public int compareTo(EcommerceOrder other) {

        return Integer.compare(
                other.priority.ordinal(),
                this.priority.ordinal()
        );
    }

    @Override
    public String toString() {

        return orderId
                + " | Customer: "
                + customerName
                + " | Priority: "
                + priority
                + " | Status: "
                + status
                + " | Total: ₹"
                + calculateTotal();
    }
}