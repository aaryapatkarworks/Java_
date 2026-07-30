class BackgroundTask extends Thread {

    public void run() {

        while (true) {

            System.out.println("Cleaning unused resources...");

            try {

                Thread.sleep(1000);

            }

            catch (InterruptedException e) {

                e.printStackTrace();

            }

        }

    }

}

public class _12_DaemonThread {

    public static void main(String[] args) {

        BackgroundTask task = new BackgroundTask();

        task.setDaemon(true);

        task.start();

        System.out.println("Main Thread Finished.");

    }

}