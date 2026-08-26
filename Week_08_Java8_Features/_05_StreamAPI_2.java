import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class _05_StreamAPI_2 {

    public static void main(String[] args) {

        List<Integer> salaries = List.of(
                50000, 60000, 70000
        );

        // reduce() - combine values into one result
        int totalSalary = salaries.stream()
                .reduce(0, Integer::sum);

        System.out.println("Total Salary: " + totalSalary);


        // reduce() - multiplication
        List<Integer> numbers = List.of(2, 3, 4);

        int multiplicationResult = numbers.stream()
                .reduce(1, (a, b) -> a * b);

        System.out.println(
                "Multiplication Result: "
                        + multiplicationResult
        );


        List<String> employees = List.of(
                "Aarya Patkar",
                "Pranav More",
                "Arnav Jadhav",
                "Pratiksha Kulkarni"
        );


        // Collectors.toList()
        List<String> employeesStartingWithA =
                employees.stream()
                        .filter(name -> name.startsWith("A"))
                        .collect(Collectors.toList());

        System.out.println(
                "\nEmployees starting with A: "
                        + employeesStartingWithA
        );


        // Collectors.toSet()
        List<String> technologies = List.of(
                "Java",
                "Python",
                "Java",
                "Spring",
                "Python"
        );

        Set<String> uniqueTechnologies =
                technologies.stream()
                        .collect(Collectors.toSet());

        System.out.println(
                "\nUnique Technologies: "
                        + uniqueTechnologies
        );


        // Collectors.joining()
        String employeeNames =
                employees.stream()
                        .collect(
                                Collectors.joining(", ")
                        );

        System.out.println(
                "\nEmployee Names: "
                        + employeeNames
        );


        // Collectors.partitioningBy()
        List<Integer> ages = List.of(
                21, 24, 17, 19, 16
        );

        Map<Boolean, List<Integer>> ageGroups =
                ages.stream()
                        .collect(
                                Collectors.partitioningBy(
                                        age -> age >= 18
                                )
                        );

        System.out.println(
                "\nAge Groups: " + ageGroups
        );
    }
}