import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class _13_Iterator {

    public static void main(String[] args) {

        // Employees currently having system access
        List<String> employees = new ArrayList<>();

        employees.add("Aarya Patkar");
        employees.add("Pranav More");
        employees.add("Arnav Jadhav");
        employees.add("Pratiksha Kulkarni");
        employees.add("Siddhi Chaudhary");
        employees.add("Nikhil Deshmukh");

        System.out.println("Current Employees:");
        System.out.println(employees);

        // Create an Iterator
        Iterator<String> iterator = employees.iterator();

        System.out.println("\nEmployees Using Iterator:");

        // Traverse the collection
        while (iterator.hasNext()) {

            String employee = iterator.next();

            System.out.println(employee);
        }

        // Create a new Iterator for removal
        iterator = employees.iterator();

        // Remove an employee safely
        while (iterator.hasNext()) {

            String employee = iterator.next();

            if (employee.equals("Arnav Jadhav")) {
                iterator.remove();
            }
        }

        System.out.println("\nAfter Removing Arnav Jadhav:");
        System.out.println(employees);

        // Remove another employee
        iterator = employees.iterator();

        while (iterator.hasNext()) {

            String employee = iterator.next();

            if (employee.equals("Siddhi Chaudhary")) {
                iterator.remove();
            }
        }

        System.out.println("\nAfter Removing Siddhi Chaudhary:");
        System.out.println(employees);

        // Final traversal
        System.out.println("\nRemaining Employees:");

        iterator = employees.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}