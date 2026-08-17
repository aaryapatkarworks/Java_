import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _16_Comparable {

    static class Employee implements Comparable<Employee> {

        private int employeeId;
        private String name;
        private double performanceScore;

        public Employee(int employeeId, String name, double performanceScore) {
            this.employeeId = employeeId;
            this.name = name;
            this.performanceScore = performanceScore;
        }

        @Override
        public int compareTo(Employee other) {

            // Higher performance score gets higher ranking
            return Double.compare(
                    other.performanceScore,
                    this.performanceScore
            );
        }

        @Override
        public String toString() {
            return employeeId + " | "
                    + name + " | Score: "
                    + performanceScore;
        }
    }

    public static void main(String[] args) {

        List<Employee> employees = new ArrayList<>();

        // Add employees in unsorted order
        employees.add(
                new Employee(501, "Aarya Patkar", 98.0)
        );

        employees.add(
                new Employee(502, "Pranav More", 95.0)
        );

        employees.add(
                new Employee(503, "Arnav Jadhav", 93.0)
        );

        employees.add(
                new Employee(504, "Pratiksha Kulkarni", 82.0)
        );

        employees.add(
                new Employee(505, "Siddhi Chaudhary", 80.0)
        );

        employees.add(
                new Employee(506, "Nikhil Deshmukh", 88.0)
        );

        System.out.println("Before Sorting:");

        for (Employee employee : employees) {
            System.out.println(employee);
        }

        // Sort using Employee's natural ordering
        Collections.sort(employees);

        System.out.println("\nAfter Sorting by Performance Score:");

        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }
}