import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

public class _03_MethodReferences {

    public static void main(String[] args) {

        List<String> employees = List.of(
                "Aarya Patkar",
                "Pranav More",
                "Arnav Jadhav",
                "Pratiksha Kulkarni"
        );

        // 1. Instance method reference
        // Lambda: name -> System.out.println(name)
        employees.forEach(System.out::println);


        // 2. Instance method reference of an arbitrary object
        // Lambda: name -> name.toUpperCase()
        Function<String, String> convertToUpperCase =
                String::toUpperCase;

        System.out.println(
                convertToUpperCase.apply("Aarya Patkar")
        );


        // 3. Static method reference
        // Lambda: value -> Integer.parseInt(value)
        Function<String, Integer> convertToInteger =
                Integer::parseInt;

        System.out.println(
                convertToInteger.apply("2026")
        );


        // 4. Constructor reference
        // Lambda: () -> new ArrayList<>()
        Supplier<List<String>> createEmployeeList =
                ArrayList::new;

        List<String> newEmployees = createEmployeeList.get();

        newEmployees.add("Nikhil Deshmukh");

        System.out.println(newEmployees);
    }
}