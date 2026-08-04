import java.util.LinkedHashSet;

public class _06_LinkedHashSet {

    public static void main(String[] args) {

        // Students enrolled in the Java Backend course
        LinkedHashSet<String> enrolledStudents = new LinkedHashSet<>();

        // 1. Add students
        enrolledStudents.add("Aarya Patkar");
        enrolledStudents.add("Pranav More");
        enrolledStudents.add("Arnav Jadhav");
        enrolledStudents.add("Pratiksha Kulkarni");
        enrolledStudents.add("Siddhi Chaudhary");
        enrolledStudents.add("Nikhil Deshmukh");

        System.out.println("Initial Enrollment:");
        System.out.println(enrolledStudents);

        // 2. Duplicate enrollment attempts
        enrolledStudents.add("Aarya Patkar");
        enrolledStudents.add("Pranav More");

        System.out.println("\nAfter Duplicate Enrollment Attempts:");
        System.out.println(enrolledStudents);

        // 3. Add null value
        enrolledStudents.add(null);

        System.out.println("\nAfter Adding Null:");
        System.out.println(enrolledStudents);

        // 4. Search for a student
        System.out.println("\nIs Siddhi Chaudhary Enrolled?");
        System.out.println(enrolledStudents.contains("Siddhi Chaudhary"));

        // 5. Remove a student
        enrolledStudents.remove("Nikhil Deshmukh");

        System.out.println("\nAfter Removing Nikhil Deshmukh:");
        System.out.println(enrolledStudents);

        // 6. Size of the set
        System.out.println("\nTotal Enrolled Students:");
        System.out.println(enrolledStudents.size());

        // 7. Iterate through the set
        System.out.println("\nEnrollment Order:");

        for (String student : enrolledStudents) {
            System.out.println(student);
        }

        // 8. Check if the set is empty
        System.out.println("\nIs Enrollment List Empty?");
        System.out.println(enrolledStudents.isEmpty());

        // 9. Clear all enrollments
        enrolledStudents.clear();

        System.out.println("\nAfter Clearing Enrollment:");
        System.out.println(enrolledStudents);

        // 10. Verify again
        System.out.println("\nIs Enrollment List Empty?");
        System.out.println(enrolledStudents.isEmpty());
    }
}