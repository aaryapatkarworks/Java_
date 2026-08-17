import java.util.HashMap;
import java.util.Map;

public class _10_HashMap {

    public static void main(String[] args) {

        // Employee ID -> Employee Name
        HashMap<Integer, String> employees = new HashMap<>();

        // 1. Add employees
        employees.put(101, "Aarya Patkar");
        employees.put(102, "Pranav More");
        employees.put(103, "Arnav Jadhav");
        employees.put(104, "Pratiksha Kulkarni");
        employees.put(105, "Siddhi Chaudhary");
        employees.put(106, "Nikhil Deshmukh");

        System.out.println("Employee Records:");
        System.out.println(employees);

        // 2. Duplicate key (updates value)
        employees.put(103, "Arnav Jadhav (Team Lead)");

        System.out.println("\nAfter Updating Employee 103:");
        System.out.println(employees);

        // 3. Get employee
        System.out.println("\nEmployee with ID 102:");
        System.out.println(employees.get(102));

        // 4. Search by key
        System.out.println("\nContains Employee ID 104?");
        System.out.println(employees.containsKey(104));

        // 5. Search by value
        System.out.println("\nContains Nikhil Deshmukh?");
        System.out.println(employees.containsValue("Nikhil Deshmukh"));

        // 6. Replace value
        employees.replace(105, "Siddhi Chaudhary (HR)");

        // 7. Remove employee
        employees.remove(106);

        System.out.println("\nAfter Replace and Remove:");
        System.out.println(employees);

        // 8. Display keys
        System.out.println("\nEmployee IDs:");
        System.out.println(employees.keySet());

        // 9. Display values
        System.out.println("\nEmployee Names:");
        System.out.println(employees.values());

        // 10. Display entries
        System.out.println("\nEmployee Details:");

        for (Map.Entry<Integer, String> entry : employees.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        // 11. Size
        System.out.println("\nTotal Employees:");
        System.out.println(employees.size());

        // 12. Check empty
        System.out.println("\nIs Employee Map Empty?");
        System.out.println(employees.isEmpty());

        // 13. Clear
        employees.clear();

        System.out.println("\nAfter Clearing:");
        System.out.println(employees);

        // 14. Verify
        System.out.println("\nIs Employee Map Empty?");
        System.out.println(employees.isEmpty());
    }
}