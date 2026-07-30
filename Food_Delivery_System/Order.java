public class Order {

    private final int orderId;
    private final String customerName;
    private final double foodAmount;

    private volatile boolean foodReady;

    public Order(int orderId,
                 String customerName,
                 double foodAmount) {

        this.orderId = orderId;
        this.customerName = customerName;
        this.foodAmount = foodAmount;
        this.foodReady = false;

    }

    public int getOrderId() {
        return orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public double getFoodAmount() {
        return foodAmount;
    }

    public boolean isFoodReady() {
        return foodReady;
    }

    public void setFoodReady(boolean foodReady) {
        this.foodReady = foodReady;
    }

}