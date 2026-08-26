import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class _02_FunctionalInterfaces {

    public static void main(String[] args) {

        // Predicate: checks a condition and returns true/false
        Predicate<Integer> isEligibleForBonus =
                experience -> experience >= 2;

        System.out.println("Bonus Eligible: "
                + isEligibleForBonus.test(3));


        // Consumer: accepts a value and performs an action
        Consumer<String> displayEmployee =
                name -> System.out.println("Employee: " + name);

        displayEmployee.accept("Aarya Patkar");


        // Function: accepts a value and transforms it
        Function<String, String> formatEmployeeName =
                name -> name.toUpperCase();

        System.out.println("Formatted Name: "
                + formatEmployeeName.apply("Pranav More"));


        // Supplier: supplies a value without taking any input
        Supplier<String> companyName =
                () -> "VishwaGuru Infotech";

        System.out.println("Company: " + companyName.get());
    }
}