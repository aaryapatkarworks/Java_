import java.util.ArrayDeque;

public class _09_ArrayDeque {

    public static void main(String[] args) {

        ArrayDeque<String> browserHistory = new ArrayDeque<>();

        // 1. Open websites
        browserHistory.addLast("Dashboard");
        browserHistory.addLast("Employee Portal");
        browserHistory.addLast("Project Tracker");
        browserHistory.addLast("Timesheet");
        browserHistory.addLast("Leave Management");

        System.out.println("Browser History:");
        System.out.println(browserHistory);

        // 2. Open urgent page at front
        browserHistory.addFirst("Security Alert");

        System.out.println("\nAfter Opening Security Alert:");
        System.out.println(browserHistory);

        // 3. First page
        System.out.println("\nCurrent First Page:");
        System.out.println(browserHistory.getFirst());

        // 4. Last page
        System.out.println("\nLast Visited Page:");
        System.out.println(browserHistory.getLast());

        // 5. Peek
        System.out.println("\nPeek First:");
        System.out.println(browserHistory.peekFirst());

        System.out.println("\nPeek Last:");
        System.out.println(browserHistory.peekLast());

        // 6. Remove first page
        browserHistory.removeFirst();

        // 7. Remove last page
        browserHistory.removeLast();

        System.out.println("\nAfter Closing Pages:");
        System.out.println(browserHistory);

        // 8. Add more pages
        browserHistory.offerLast("Performance Dashboard");
        browserHistory.offerFirst("Admin Login");

        System.out.println("\nAfter Opening More Pages:");
        System.out.println(browserHistory);

        // 9. Search
        System.out.println("\nContains Project Tracker?");
        System.out.println(browserHistory.contains("Project Tracker"));

        // 10. Size
        System.out.println("\nTotal Pages:");
        System.out.println(browserHistory.size());

        // 11. Traverse
        System.out.println("\nComplete Browser History:");

        for (String page : browserHistory) {
            System.out.println(page);
        }

        // 12. Poll operations
        System.out.println("\nRemoved First Page:");
        System.out.println(browserHistory.pollFirst());

        System.out.println("\nRemoved Last Page:");
        System.out.println(browserHistory.pollLast());

        System.out.println("\nRemaining History:");
        System.out.println(browserHistory);

        // 13. Clear
        browserHistory.clear();

        System.out.println("\nAfter Clearing:");
        System.out.println(browserHistory);

        // 14. Check empty
        System.out.println("\nIs Browser History Empty?");
        System.out.println(browserHistory.isEmpty());
    }
}