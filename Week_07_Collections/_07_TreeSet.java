import java.util.TreeSet;

public class _07_TreeSet {

    public static void main(String[] args) {

        // Patients scheduled for appointments
        TreeSet<String> patients = new TreeSet<>();

        // 1. Add patients (random order)
        patients.add("Pranav More");
        patients.add("Nikhil Deshmukh");
        patients.add("Aarya Patkar");
        patients.add("Arnav Jadhav");
        patients.add("Arnav Karwa");
        patients.add("Pratiksha Kulkarni");
        patients.add("Siddhi Chaudhary");

        System.out.println("Patients (Automatically Sorted):");
        System.out.println(patients);

        // 2. Duplicate entry
        patients.add("Aarya Patkar");

        System.out.println("\nAfter Duplicate Entry:");
        System.out.println(patients);

        // 3. Search
        System.out.println("\nIs Arnav Jadhav Scheduled?");
        System.out.println(patients.contains("Arnav Jadhav"));

        // 4. First patient
        System.out.println("\nFirst Patient:");
        System.out.println(patients.first());

        // 5. Last patient
        System.out.println("\nLast Patient:");
        System.out.println(patients.last());

        // 6. Higher patient
        System.out.println("\nPatient After Arnav Jadhav:");
        System.out.println(patients.higher("Arnav Jadhav"));

        // 7. Lower patient
        System.out.println("\nPatient Before Pranav More:");
        System.out.println(patients.lower("Pranav More"));

        // 8. Ceiling
        System.out.println("\nCeiling of Arnav Jadhav:");
        System.out.println(patients.ceiling("Arnav Jadhav"));

        // 9. Floor
        System.out.println("\nFloor of Pranav More:");
        System.out.println(patients.floor("Pranav More"));

        // 10. Remove patient
        patients.remove("Siddhi Chaudhary");

        System.out.println("\nAfter Removing Siddhi Chaudhary:");
        System.out.println(patients);

        // 11. Size
        System.out.println("\nTotal Patients:");
        System.out.println(patients.size());

        // 12. Iterate
        System.out.println("\nAppointment Order:");

        for (String patient : patients) {
            System.out.println(patient);
        }

        // 13. Clear
        patients.clear();

        System.out.println("\nAfter Clearing:");
        System.out.println(patients);

        // 14. Check empty
        System.out.println("\nIs Appointment List Empty?");
        System.out.println(patients.isEmpty());
    }
}