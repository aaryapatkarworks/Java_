import java.util.HashSet;

public class _05_HashSet {

    public static void main(String[] args) {

        HashSet<String> registeredStudents = new HashSet<>();

        // 1. Add registrations
        registeredStudents.add("Rahul Sharma");
        registeredStudents.add("Priya Patel");
        registeredStudents.add("Aman Verma");
        registeredStudents.add("Neha Joshi");

        // Duplicate registrations
        registeredStudents.add("Rahul Sharma");
        registeredStudents.add("Priya Patel");

        System.out.println("Registered Students:");
        System.out.println(registeredStudents);

        // 2. Add null
        registeredStudents.add(null);

        System.out.println("\nAfter Adding Null:");
        System.out.println(registeredStudents);

        // 3. Search
        System.out.println("\nIs Aman Verma Registered?");
        System.out.println(registeredStudents.contains("Aman Verma"));

        // 4. Remove
        registeredStudents.remove("Neha Joshi");

        System.out.println("\nAfter Removing Neha:");
        System.out.println(registeredStudents);

        // 5. Size
        System.out.println("\nTotal Registrations:");
        System.out.println(registeredStudents.size());

        // 6. Iterate
        System.out.println("\nStudent List:");

        for (String student : registeredStudents) {
            System.out.println(student);
        }

        // 7. Is Empty
        System.out.println("\nIs Registration Empty?");
        System.out.println(registeredStudents.isEmpty());

        // 8. Clear
        registeredStudents.clear();

        System.out.println("\nAfter Clearing:");
        System.out.println(registeredStudents);

        System.out.println("\nIs Registration Empty?");
        System.out.println(registeredStudents.isEmpty());
    }
}