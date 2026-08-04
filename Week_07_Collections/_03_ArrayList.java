import java.util.ArrayList;
import java.util.List;

public class _03_ArrayList {

    public static void main(String[] args) {

        // Employee records
        List<String> employees = new ArrayList<>();

        // 1. Add employees
        employees.add("Rahul Sharma");
        employees.add("Priya Patel");
        employees.add("Aman Verma");
        employees.add("Neha Joshi");

        System.out.println("Employees:");
        System.out.println(employees);

        // 2. Add employee at specific index
        employees.add(2, "Arjun Mehta");

        System.out.println("\nAfter Inserting Arjun:");
        System.out.println(employees);

        // 3. Get employee by index
        System.out.println("\nEmployee at Index 1:");
        System.out.println(employees.get(1));

        // 4. Update employee
        employees.set(3, "Aman Singh");

        System.out.println("\nAfter Updating:");
        System.out.println(employees);

        // 5. Search employee
        System.out.println("\nContains Priya Patel?");
        System.out.println(employees.contains("Priya Patel"));

        // 6. Index of employee
        System.out.println("\nIndex of Aman Singh:");
        System.out.println(employees.indexOf("Aman Singh"));

        // 7. Remove employee by object
        employees.remove("Rahul Sharma");

        // 8. Remove employee by index
        employees.remove(2);

        System.out.println("\nAfter Removal:");
        System.out.println(employees);

        // 9. Size
        System.out.println("\nTotal Employees:");
        System.out.println(employees.size());

        // 10. Check if empty
        System.out.println("\nIs Employee List Empty?");
        System.out.println(employees.isEmpty());

        // 11. Iterate using enhanced for loop
        System.out.println("\nEmployee List:");

        for (String employee : employees) {
            System.out.println(employee);
        }

        // 12. Clear list
        employees.clear();

        System.out.println("\nAfter Clearing:");
        System.out.println(employees);

        // 13. Verify empty
        System.out.println("\nIs Employee List Empty?");
        System.out.println(employees.isEmpty());
    }
}