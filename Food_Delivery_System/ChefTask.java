public class ChefTask implements Runnable {

    private final Restaurant restaurant;
    private final Order order;

    public ChefTask(Restaurant restaurant, Order order) {

        this.restaurant = restaurant;
        this.order = order;

    }

    @Override
    public void run() {

        try {

            System.out.println(
                    Thread.currentThread().getName()
                            + " accepted Order "
                            + order.getOrderId()
            );

            System.out.println(
                    Thread.currentThread().getName()
                            + " is preparing food for "
                            + order.getCustomerName()
            );

            Thread.sleep(3000);

            restaurant.markFoodReady(order);

        }

        catch (InterruptedException e) {

            Thread.currentThread().interrupt();

        }

    }

}