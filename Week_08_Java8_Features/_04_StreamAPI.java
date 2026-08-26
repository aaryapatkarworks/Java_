import java.util.List;

public class _04_StreamAPI {

    public static void main(String[] args) {

        List<String> employees = List.of(
                "Aarya Patkar",
                "Pranav More",
                "Arnav Jadhav",
                "Pratiksha Kulkarni",
                "Nikhil Deshmukh",
                "Siddhi Chaudhary"
        );

        // 1. filter() + map() + sorted() + toList()
        List<String> employeesStartingWithA =
                employees.stream()
                        .filter(name -> name.startsWith("A"))
                        .map(String::toUpperCase)
                        .sorted()
                        .toList();

        System.out.println("Employees starting with A:");
        System.out.println(employeesStartingWithA);


        // 2. distinct()
        List<String> technologies = List.of(
                "Java",
                "Python",
                "Java",
                "Spring",
                "Python"
        );

        System.out.println("\nUnique Technologies:");

        technologies.stream()
                .distinct()
                .forEach(System.out::println);


        // 3. limit()
        System.out.println("\nFirst 3 Employees:");

        employees.stream()
                .limit(3)
                .forEach(System.out::println);


        // 4. skip()
        System.out.println("\nEmployees after skipping first 2:");

        employees.stream()
                .skip(2)
                .forEach(System.out::println);


        // 5. count()
        long employeeCount = employees.stream()
                .filter(name -> name.startsWith("A"))
                .count();

        System.out.println("\nEmployees starting with A: "
                + employeeCount);


        // 6. findFirst()
        String firstEmployee = employees.stream()
                .filter(name -> name.startsWith("A"))
                .findFirst()
                .orElse("No employee found");

        System.out.println("\nFirst employee starting with A: "
                + firstEmployee);


        // 7. findAny()
        String anyEmployee = employees.stream()
                .filter(name -> name.contains("a"))
                .findAny()
                .orElse("No employee found");

        System.out.println("\nAny employee containing 'a': "
                + anyEmployee);


        // 8. anyMatch()
        boolean hasAarya = employees.stream()
                .anyMatch(name -> name.equals("Aarya Patkar"));

        System.out.println("\nDoes Aarya exist? " + hasAarya);


        // 9. allMatch()
        List<Integer> ages = List.of(21, 24, 19, 22);

        boolean allAdults = ages.stream()
                .allMatch(age -> age >= 18);

        System.out.println("Are all employees adults? "
                + allAdults);


        // 10. noneMatch()
        boolean noMinor = ages.stream()
                .noneMatch(age -> age < 18);

        System.out.println("Are there no minors? "
                + noMinor);
    }
}