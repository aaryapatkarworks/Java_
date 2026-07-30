class DownloadThread extends Thread {

    @Override
    public void run() {

        // Work done by this thread
        System.out.println("Downloading file...");

    }
}

public class _02_ExtendingThread {

    public static void main(String[] args) {

        DownloadThread thread = new DownloadThread();

        // Starts a new thread
        thread.start();

        System.out.println("Main thread is still running.");

    }

}