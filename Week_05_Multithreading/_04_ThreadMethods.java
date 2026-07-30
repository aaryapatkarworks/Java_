class Download_Thread extends Thread {

    @Override
    public void run() {

        try {

            System.out.println(getName() + " started downloading...");

            Thread.sleep(3000);   // Pause for 3 seconds

            System.out.println(getName() + " download completed.");

        } catch (InterruptedException e) {

            System.out.println("Thread Interrupted.");

        }

    }

}

public class _04_ThreadMethods {

    public static void main(String[] args) throws InterruptedException {

        Download_Thread thread = new Download_Thread();

        thread.setName("File Download Thread");

        thread.start();

        System.out.println("Main thread waiting...");

        thread.join();   // Wait until download finishes

        System.out.println("Main thread continues.");

    }

}