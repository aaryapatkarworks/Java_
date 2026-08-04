import java.util.ArrayList;
import java.util.List;

public class _01_IntroductionToCollections {

    public static void main(String[] args) {

        // Creating a dynamic list of products
        List<String> products = new ArrayList<>();

        // Adding products
        products.add("Laptop");
        products.add("Phone");
        products.add("Tablet");

        // Adding a new product dynamically
        products.add("Smartwatch");

        // Removing a product
        products.remove("Tablet");

        System.out.println("Available Products:");

        for (String product : products) {
            System.out.println(product);
        }

        System.out.println("\nTotal Products: " + products.size());
    }
}