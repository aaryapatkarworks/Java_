import java.util.concurrent.CompletableFuture;

public class _14_CompletableFuture {

        public static void main(String[] args) {

            CompletableFuture
                    .supplyAsync(() -> {

                        System.out.println("Preparing Food...");

                        return "Pizza";

                    })

                    .thenApply(food -> {

                        System.out.println(food + " Prepared");

                        return food;

                    })

                    .thenAccept(food ->

                            System.out.println(food + " Delivered"));

        }
}
