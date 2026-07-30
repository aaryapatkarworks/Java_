import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class PrintTask implements Runnable {

    private int taskNumber;

    public PrintTask(int taskNumber) {

        this.taskNumber = taskNumber;

    }

    @Override
    public void run() {

        System.out.println(
                Thread.currentThread().getName()
                        + " is executing Task "
                        + taskNumber
        );

    }

}

public class _09_ExecutorService {

    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(3);

        for (int i = 1; i <= 7; i++) {

            executor.submit(new PrintTask(i));

        }

        executor.shutdown();

    }

}