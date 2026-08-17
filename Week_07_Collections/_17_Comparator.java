import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class _17_Comparator {

    static class Employee {

        private int employeeId;
        private String name;
        private double salary;
        private double performanceScore;

        public Employee(
                int employeeId,
                String name,
                double salary,
                double performanceScore
        ) {
            this.employeeId = employeeId;
            this.name = name;
            this.salary = salary;
            this.performanceScore = performanceScore;
        }

        public int getEmployeeId() {
            return employeeId;
        }

        public String getName() {
            return name;
        }

        public double getSalary() {
            return salary;
        }

        public double getPerformanceScore() {
            return performanceScore;
        }

        @Override
        public String toString() {
            return employeeId
                    + " | "
                    + name
                    + " | Salary: ₹"
                    + salary
                    + " | Performance: "
                    + performanceScore;
        }
    }

    public static void main(String[] args) {

        List<Employee> employees = new ArrayList<>();

        employees.add(
                new Employee(
                        601,
                        "Aarya Patkar",
                        85000,
                        91
                )
        );

        employees.add(
                new Employee(
                        602,
                        "Pranav More",
                        72000,
                        87
                )
        );

        employees.add(
                new Employee(
                        603,
                        "Arnav Jadhav",
                        95000,
                        96
                )
        );

        employees.add(
                new Employee(
                        604,
                        "Pratiksha Kulkarni",
                        78000,
                        91
                )
        );

        employees.add(
                new Employee(
                        605,
                        "Siddhi Chaudhary",
                        85000,
                        94
                )
        );

        employees.add(
                new Employee(
                        606,
                        "Nikhil Deshmukh",
                        68000,
                        82
                )
        );

        // 1. Sort by salary - ascending
        employees.sort(
                Comparator.comparing(Employee::getSalary)
        );

        System.out.println("Salary - Ascending:");

        for (Employee employee : employees) {
            System.out.println(employee);
        }

        // 2. Sort by salary - descending
        employees.sort(
                Comparator.comparing(Employee::getSalary)
                        .reversed()
        );

        System.out.println("\nSalary - Descending:");

        for (Employee employee : employees) {
            System.out.println(employee);
        }

        // 3. Sort by performance - highest first
        employees.sort(
                Comparator.comparing(
                        Employee::getPerformanceScore
                ).reversed()
        );

        System.out.println("\nPerformance - Highest First:");

        for (Employee employee : employees) {
            System.out.println(employee);
        }

        // 4. Sort alphabetically by name
        employees.sort(
                Comparator.comparing(Employee::getName)
        );

        System.out.println("\nName - A to Z:");

        for (Employee employee : employees) {
            System.out.println(employee);
        }

        // 5. Sort by employee ID
        employees.sort(
                Comparator.comparingInt(
                        Employee::getEmployeeId
                )
        );

        System.out.println("\nEmployee ID - Ascending:");

        for (Employee employee : employees) {
            System.out.println(employee);
        }

        // 6. Multi-level sorting
        // First by performance, then by name
        employees.sort(
                Comparator.comparing(
                                Employee::getPerformanceScore
                        ).reversed()
                        .thenComparing(Employee::getName)
        );

        System.out.println(
                "\nPerformance - Highest First, "
                        + "Name as Tie-Breaker:"
        );

        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }
}