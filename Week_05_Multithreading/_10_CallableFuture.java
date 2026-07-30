import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class _10_CallableFuture {

    public static void main(String[] args) throws Exception {

        ExecutorService executor = Executors.newFixedThreadPool(2);

        Callable<Integer> squareTask = () -> {

            System.out.println("Calculating Square...");

            Thread.sleep(2000);

            return 25;

        };

        Future<Integer> future = executor.submit(squareTask);

        System.out.println("Main Thread is doing other work...");

        int result = future.get();

        System.out.println("Result : " + result);

        executor.shutdown();

    }

}