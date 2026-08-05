public class DeliveryTask implements Runnable {

    private final Restaurant restaurant;
    private final Order order;

    public DeliveryTask(Restaurant restaurant, Order order) {

        this.restaurant = restaurant;
        this.order = order;

    }

    @Override
    public void run() {

        restaurant.waitForFood(order);

        System.out.println(
                Thread.currentThread().getName()
                        + " picked up Order "
                        + order.getOrderId()
        );

        try {

            System.out.println(
                    Thread.currentThread().getName()
                            + " is delivering to "
                            + order.getCustomerName()
            );

            Thread.sleep(2000);

        }

        catch (InterruptedException e) {

            Thread.currentThread().interrupt();

        }

        restaurant.completeOrder();

        System.out.println(
                "Order "
                        + order.getOrderId()
                        + " Delivered Successfully."
        );

    }

}