class EmailTask implements Runnable {

    @Override
    public void run() {

        System.out.println("Sending Email...");

    }

}

public class _03_ImplementRunnable {

    public static void main(String[] args) {

        EmailTask task = new EmailTask();

        Thread thread = new Thread(task);

        thread.start();

        System.out.println("Main thread continues...");

    }

}