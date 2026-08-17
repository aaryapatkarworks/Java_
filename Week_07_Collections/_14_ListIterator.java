import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class _14_ListIterator {

    public static void main(String[] args) {

        List<String> orders = new ArrayList<>();

        orders.add("Order-1001 - Aarya Patkar");
        orders.add("Order-1002 - Pranav More");
        orders.add("Order-1003 - Arnav Jadhav");
        orders.add("Order-1004 - Pratiksha Kulkarni");
        orders.add("Order-1005 - Siddhi Chaudhary");
        orders.add("Order-1006 - Nikhil Deshmukh");

        System.out.println("Original Orders:");
        System.out.println(orders);

        // Create ListIterator
        ListIterator<String> iterator = orders.listIterator();

        // 1. Forward traversal
        System.out.println("\nForward Traversal:");

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        // 2. Backward traversal
        System.out.println("\nBackward Traversal:");

        while (iterator.hasPrevious()) {
            System.out.println(iterator.previous());
        }

        // 3. Move to Order-1003
        iterator.next();
        iterator.next();
        String currentOrder = iterator.next();

        System.out.println("\nCurrent Order:");
        System.out.println(currentOrder);

        // 4. Replace current order
        iterator.set("Order-1003 - Arnav Jadhav - Priority Delivery");

        System.out.println("\nAfter Updating Order-1003:");
        System.out.println(orders);

        // 5. Add a new order
        iterator.add("Order-1007 - Nikhil Deshmukh - Express");

        System.out.println("\nAfter Adding New Order:");
        System.out.println(orders);

        // 6. Move to next order and remove it
        iterator.next();
        iterator.remove();

        System.out.println("\nAfter Removing Order:");
        System.out.println(orders);

        // 7. Index information
        System.out.println("\nNext Index:");
        System.out.println(iterator.nextIndex());

        System.out.println("\nPrevious Index:");
        System.out.println(iterator.previousIndex());

        // 8. Final traversal
        System.out.println("\nFinal Order List:");

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}