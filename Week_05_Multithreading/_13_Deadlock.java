public class _13_Deadlock {

    private static final Object LOCK1 = new Object();
    private static final Object LOCK2 = new Object();

    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {

            synchronized (LOCK1) {

                System.out.println("Thread 1 locked LOCK1");

                try {

                    Thread.sleep(100);

                }

                catch (InterruptedException e) {

                }

                synchronized (LOCK2) {

                    System.out.println("Thread 1 locked LOCK2");

                }

            }

        });

        Thread t2 = new Thread(() -> {

            synchronized (LOCK2) {

                System.out.println("Thread 2 locked LOCK2");

                try {

                    Thread.sleep(100);

                }

                catch (InterruptedException e) {

                }

                synchronized (LOCK1) {

                    System.out.println("Thread 2 locked LOCK1");

                }

            }

        });

        t1.start();
        t2.start();

    }

}