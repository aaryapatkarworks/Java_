import java.util.Map;
import java.util.TreeMap;

public class _12_TreeMap {

    public static void main(String[] args) {

        // Transaction ID -> Transaction Description
        TreeMap<Integer, String> transactions = new TreeMap<>();

        // 1. Add transactions in random order
        transactions.put(5007, "UPI Payment - Electricity Bill");
        transactions.put(5002, "Salary Credit");
        transactions.put(5010, "Credit Card Payment");
        transactions.put(5001, "ATM Withdrawal");
        transactions.put(5005, "Online Shopping Payment");
        transactions.put(5008, "Mutual Fund Investment");

        System.out.println("Transactions Sorted by Transaction ID:");
        System.out.println(transactions);

        // 2. Update an existing transaction
        transactions.put(5005, "Online Shopping Refund");

        System.out.println("\nAfter Updating Transaction 5005:");
        System.out.println(transactions);

        // 3. Get transaction
        System.out.println("\nTransaction 5002:");
        System.out.println(transactions.get(5002));

        // 4. Search by key
        System.out.println("\nContains Transaction 5010?");
        System.out.println(transactions.containsKey(5010));

        // 5. Search by value
        System.out.println("\nContains Salary Credit?");
        System.out.println(transactions.containsValue("Salary Credit"));

        // 6. First transaction
        System.out.println("\nFirst Transaction ID:");
        System.out.println(transactions.firstKey());

        // 7. Last transaction
        System.out.println("\nLast Transaction ID:");
        System.out.println(transactions.lastKey());

        // 8. Higher key
        System.out.println("\nTransaction ID Higher Than 5005:");
        System.out.println(transactions.higherKey(5005));

        // 9. Lower key
        System.out.println("\nTransaction ID Lower Than 5005:");
        System.out.println(transactions.lowerKey(5005));

        // 10. Ceiling key
        System.out.println("\nCeiling Transaction ID for 5006:");
        System.out.println(transactions.ceilingKey(5006));

        // 11. Floor key
        System.out.println("\nFloor Transaction ID for 5006:");
        System.out.println(transactions.floorKey(5006));

        // 12. Remove transaction
        transactions.remove(5008);

        System.out.println("\nAfter Removing Transaction 5008:");
        System.out.println(transactions);

        // 13. Display keys
        System.out.println("\nTransaction IDs:");
        System.out.println(transactions.keySet());

        // 14. Display values
        System.out.println("\nTransaction Details:");
        System.out.println(transactions.values());

        // 15. Iterate through entries
        System.out.println("\nTransaction History:");

        for (Map.Entry<Integer, String> entry : transactions.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        // 16. Size
        System.out.println("\nTotal Transactions:");
        System.out.println(transactions.size());

        // 17. Check empty
        System.out.println("\nIs Transaction Map Empty?");
        System.out.println(transactions.isEmpty());

        // 18. Clear
        transactions.clear();

        System.out.println("\nAfter Clearing:");
        System.out.println(transactions);

        // 19. Verify empty
        System.out.println("\nIs Transaction Map Empty?");
        System.out.println(transactions.isEmpty());
    }
}