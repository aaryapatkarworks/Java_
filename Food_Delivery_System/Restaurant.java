import java.util.concurrent.atomic.AtomicInteger;

public class Restaurant {

    // Thread-safe counter
    private final AtomicInteger completedOrders = new AtomicInteger(0);

    // Chef calls this after preparing food
    public synchronized void markFoodReady(Order order) {

        order.setFoodReady(true);

        System.out.println("--------------------------------------");
        System.out.println("Food Ready for Order : " + order.getOrderId());
        System.out.println("--------------------------------------");

        notifyAll();

    }

    // Delivery partner waits until food is ready
    public synchronized void waitForFood(Order order) {

        while (!order.isFoodReady()) {

            try {

                System.out.println(
                        Thread.currentThread().getName()
                                + " is waiting for food..."
                );

                wait();

            }

            catch (InterruptedException e) {

                Thread.currentThread().interrupt();

            }

        }

    }

    public void completeOrder() {

        completedOrders.incrementAndGet();

    }

    public int getCompletedOrders() {

        return completedOrders.get();

    }

}