import java.util.PriorityQueue;

public class _08_PriorityQueue {

    public static void main(String[] args) {

        // Lower number = Higher priority
        PriorityQueue<Integer> emergencyQueue = new PriorityQueue<>();

        // 1. Add emergency priority levels
        emergencyQueue.offer(3); // Aarya Patkar
        emergencyQueue.offer(5); // Pranav More
        emergencyQueue.offer(1); // Arnav Jadhav
        emergencyQueue.offer(4); // Pratiksha Kulkarni
        emergencyQueue.offer(2); // Siddhi Chaudhary
        emergencyQueue.offer(6); // Nikhil Deshmukh

        System.out.println("Emergency Queue:");
        System.out.println(emergencyQueue);

        // 2. Peek
        System.out.println("\nHighest Priority:");
        System.out.println(emergencyQueue.peek());

        // 3. Contains
        System.out.println("\nContains Priority 4?");
        System.out.println(emergencyQueue.contains(4));

        // 4. Remove specific priority
        emergencyQueue.remove(5);

        System.out.println("\nAfter Removing Priority 5:");
        System.out.println(emergencyQueue);

        // 5. Size
        System.out.println("\nQueue Size:");
        System.out.println(emergencyQueue.size());

        // 6. Process patients
        System.out.println("\nProcessing Patients:");

        while (!emergencyQueue.isEmpty()) {
            System.out.println("Priority " + emergencyQueue.poll());
        }

        // 7. Check empty
        System.out.println("\nIs Queue Empty?");
        System.out.println(emergencyQueue.isEmpty());
    }
}