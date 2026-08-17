import java.util.ArrayList;
import java.util.List;

public class _15_Generics {

    // Generic class
    static class EmployeeRecord<T> {

        private T value;

        public EmployeeRecord(T value) {
            this.value = value;
        }

        public T getValue() {
            return value;
        }
    }

    // Generic class with two type parameters
    static class EmployeeDetails<K, V> {

        private K employeeId;
        private V employeeName;

        public EmployeeDetails(K employeeId, V employeeName) {
            this.employeeId = employeeId;
            this.employeeName = employeeName;
        }

        public void display() {
            System.out.println(employeeId + " -> " + employeeName);
        }
    }

    // Generic method
    public static <T> void displayData(T data) {
        System.out.println("Data: " + data);
    }

    public static void main(String[] args) {

        // 1. Type-safe String list
        List<String> employees = new ArrayList<>();

        employees.add("Aarya Patkar");
        employees.add("Pranav More");
        employees.add("Arnav Jadhav");
        employees.add("Pratiksha Kulkarni");
        employees.add("Siddhi Chaudhary");
        employees.add("Nikhil Deshmukh");

        System.out.println("Employees:");

        for (String employee : employees) {
            System.out.println(employee);
        }

        // 2. Type-safe Integer list
        List<Integer> employeeIds = new ArrayList<>();

        employeeIds.add(501);
        employeeIds.add(502);
        employeeIds.add(503);

        System.out.println("\nEmployee IDs:");
        System.out.println(employeeIds);

        // 3. Generic class with String
        EmployeeRecord<String> employeeName =
                new EmployeeRecord<>("Aarya Patkar");

        System.out.println("\nGeneric String Record:");
        System.out.println(employeeName.getValue());

        // 4. Generic class with Integer
        EmployeeRecord<Integer> employeeId =
                new EmployeeRecord<>(501);

        System.out.println("\nGeneric Integer Record:");
        System.out.println(employeeId.getValue());

        // 5. Multiple type parameters
        EmployeeDetails<Integer, String> employee =
                new EmployeeDetails<>(
                        504,
                        "Pratiksha Kulkarni"
                );

        System.out.println("\nEmployee Details:");
        employee.display();

        // 6. Generic method
        System.out.println("\nGeneric Method:");

        displayData("Nikhil Deshmukh");
        displayData(506);
        displayData(85.5);
    }
}