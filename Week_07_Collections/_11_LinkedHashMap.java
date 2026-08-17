import java.util.LinkedHashMap;
import java.util.Map;

public class _11_LinkedHashMap {

    public static void main(String[] args) {

        // Employee ID -> Employee Name
        LinkedHashMap<Integer, String> onboardingEmployees = new LinkedHashMap<>();

        // 1. Add employees in onboarding order
        onboardingEmployees.put(501, "Aarya Patkar");
        onboardingEmployees.put(502, "Pranav More");
        onboardingEmployees.put(503, "Arnav Jadhav");
        onboardingEmployees.put(504, "Pratiksha Kulkarni");
        onboardingEmployees.put(505, "Siddhi Chaudhary");
        onboardingEmployees.put(506, "Nikhil Deshmukh");

        System.out.println("Employee Onboarding Order:");
        System.out.println(onboardingEmployees);

        // 2. Update an existing employee
        onboardingEmployees.put(503, "Arnav Jadhav - Backend Team");

        System.out.println("\nAfter Updating Employee 503:");
        System.out.println(onboardingEmployees);

        // 3. Get employee by ID
        System.out.println("\nEmployee with ID 502:");
        System.out.println(onboardingEmployees.get(502));

        // 4. Check whether an employee ID exists
        System.out.println("\nContains Employee ID 504?");
        System.out.println(onboardingEmployees.containsKey(504));

        // 5. Check whether an employee name exists
        System.out.println("\nContains Aarya Patkar?");
        System.out.println(onboardingEmployees.containsValue("Aarya Patkar"));

        // 6. Replace an employee's value
        onboardingEmployees.replace(505, "Siddhi Chaudhary - HR");

        // 7. Remove an employee
        onboardingEmployees.remove(506);

        System.out.println("\nAfter Replace and Remove:");
        System.out.println(onboardingEmployees);

        // 8. Display only employee IDs
        System.out.println("\nEmployee IDs:");
        System.out.println(onboardingEmployees.keySet());

        // 9. Display only employee names
        System.out.println("\nEmployee Names:");
        System.out.println(onboardingEmployees.values());

        // 10. Display entries in insertion order
        System.out.println("\nOnboarding Sequence:");

        for (Map.Entry<Integer, String> entry : onboardingEmployees.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        // 11. Size
        System.out.println("\nTotal Employees:");
        System.out.println(onboardingEmployees.size());

        // 12. Check empty
        System.out.println("\nIs Onboarding Tracker Empty?");
        System.out.println(onboardingEmployees.isEmpty());

        // 13. Clear
        onboardingEmployees.clear();

        System.out.println("\nAfter Clearing:");
        System.out.println(onboardingEmployees);

        // 14. Verify empty
        System.out.println("\nIs Onboarding Tracker Empty?");
        System.out.println(onboardingEmployees.isEmpty());
    }
}