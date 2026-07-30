class WorkerThread extends Thread {

    @Override
    public void run() {

        try {

            System.out.println("Thread is Running...");

            Thread.sleep(2000);

            System.out.println("Thread Finished.");

        }

        catch (InterruptedException e) {

            System.out.println("Thread Interrupted.");

        }

    }

}

public class _05_ThreadLifecycle {

    public static void main(String[] args) throws InterruptedException {

        WorkerThread thread = new WorkerThread();

        // NEW
        System.out.println("State : " + thread.getState());

        thread.start();

        // Give JVM some time to start the thread
        Thread.sleep(100);

        System.out.println("State : " + thread.getState());

        thread.join();

        // TERMINATED
        System.out.println("State : " + thread.getState());

    }

}