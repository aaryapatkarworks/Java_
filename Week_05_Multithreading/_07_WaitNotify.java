class Restaurant {

    private boolean foodReady = false;

    public synchronized void waiter() {

        while (!foodReady) {

            try {

                System.out.println("Waiter : Waiting for food...");

                wait(); // Releases the lock and waits

            } catch (InterruptedException e) {

                e.printStackTrace();

            }

        }

        System.out.println("Waiter : Serving the food.");

    }

    public synchronized void chef() {

        System.out.println("Chef : Preparing food...");

        foodReady = true;

        System.out.println("Chef : Food is ready.");

        notify(); // Wake one waiting thread

    }

}

public class _07_WaitNotify {

    public static void main(String[] args) {

        Restaurant restaurant = new Restaurant();

        Thread waiter = new Thread(() -> restaurant.waiter());

        Thread chef = new Thread(() -> restaurant.chef());

        waiter.start();

        try {

            Thread.sleep(2000);

        } catch (InterruptedException e) {

            e.printStackTrace();

        }

        chef.start();

    }

}