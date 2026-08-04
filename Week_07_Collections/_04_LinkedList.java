import java.util.LinkedList;

public class _04_LinkedList {

    public static void main(String[] args) {

        // Customer support tickets
        LinkedList<String> tickets = new LinkedList<>();

        // 1. Add tickets
        tickets.add("TCK-101 : Login Issue");
        tickets.add("TCK-102 : Payment Failed");
        tickets.add("TCK-103 : Password Reset");

        System.out.println("Initial Tickets:");
        System.out.println(tickets);

        // 2. Add urgent ticket at beginning
        tickets.addFirst("TCK-100 : Server Down");

        // 3. Add ticket at end
        tickets.addLast("TCK-104 : Order Tracking");

        System.out.println("\nAfter Adding Tickets:");
        System.out.println(tickets);

        // 4. Access first and last ticket
        System.out.println("\nFirst Ticket:");
        System.out.println(tickets.getFirst());

        System.out.println("\nLast Ticket:");
        System.out.println(tickets.getLast());

        // 5. Peek first and last
        System.out.println("\nPeek First:");
        System.out.println(tickets.peekFirst());

        System.out.println("Peek Last:");
        System.out.println(tickets.peekLast());

        // 6. Remove first resolved ticket
        tickets.removeFirst();

        // 7. Remove last ticket
        tickets.removeLast();

        System.out.println("\nAfter Removing Tickets:");
        System.out.println(tickets);

        // 8. Search ticket
        System.out.println("\nContains Payment Failed?");
        System.out.println(tickets.contains("TCK-102 : Payment Failed"));

        // 9. Get ticket using index
        System.out.println("\nTicket at Index 1:");
        System.out.println(tickets.get(1));

        // 10. Update ticket
        tickets.set(1, "TCK-102 : Payment Successful");

        System.out.println("\nAfter Updating:");
        System.out.println(tickets);

        // 11. Size
        System.out.println("\nTotal Tickets:");
        System.out.println(tickets.size());

        // 12. Iterate
        System.out.println("\nTicket Queue:");

        for (String ticket : tickets) {
            System.out.println(ticket);
        }

        // 13. Clear
        tickets.clear();

        System.out.println("\nAfter Clearing:");
        System.out.println(tickets);

        System.out.println("\nIs Queue Empty?");
        System.out.println(tickets.isEmpty());
    }
}