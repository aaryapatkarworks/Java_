import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class _18_CollectionsUtilityDemo {

    public static void main(String[] args) {

        // Order processing times in minutes
        List<Integer> processingTimes =
                new ArrayList<>(
                        Arrays.asList(
                                45, 20, 60, 30, 20, 90, 45
                        )
                );

        System.out.println("Original Processing Times:");
        System.out.println(processingTimes);

        // 1. Sort
        Collections.sort(processingTimes);

        System.out.println("\nAfter Sorting:");
        System.out.println(processingTimes);

        // 2. Reverse
        Collections.reverse(processingTimes);

        System.out.println("\nAfter Reversing:");
        System.out.println(processingTimes);

        // 3. Maximum
        System.out.println("\nLongest Processing Time:");
        System.out.println(Collections.max(processingTimes));

        // 4. Minimum
        System.out.println("\nShortest Processing Time:");
        System.out.println(Collections.min(processingTimes));

        // 5. Frequency
        System.out.println("\nOrders Taking 20 Minutes:");
        System.out.println(
                Collections.frequency(processingTimes, 20)
        );

        // 6. Swap
        Collections.swap(processingTimes, 0, 2);

        System.out.println("\nAfter Swapping Index 0 and 2:");
        System.out.println(processingTimes);

        // 7. Sort again before binary search
        Collections.sort(processingTimes);

        int searchResult =
                Collections.binarySearch(
                        processingTimes,
                        45
                );

        System.out.println("\nBinary Search Result for 45:");
        System.out.println(searchResult);

        // 8. Fill
        List<String> orderStatuses =
                new ArrayList<>(
                        Arrays.asList(
                                "PENDING",
                                "PENDING",
                                "PENDING",
                                "PENDING"
                        )
                );

        Collections.fill(
                orderStatuses,
                "PROCESSING"
        );

        System.out.println("\nAfter Fill:");
        System.out.println(orderStatuses);

        // 9. Replace All
        List<String> deliveryStatuses =
                new ArrayList<>(
                        Arrays.asList(
                                "PENDING",
                                "SHIPPED",
                                "PENDING",
                                "DELIVERED",
                                "PENDING"
                        )
                );

        Collections.replaceAll(
                deliveryStatuses,
                "PENDING",
                "PROCESSING"
        );

        System.out.println("\nAfter Replacing PENDING:");
        System.out.println(deliveryStatuses);

        // 10. Rotate
        List<Integer> orderQueue =
                new ArrayList<>(
                        Arrays.asList(
                                101, 102, 103, 104, 105
                        )
                );

        Collections.rotate(orderQueue, 2);

        System.out.println("\nAfter Rotating Order Queue:");
        System.out.println(orderQueue);

        // 11. Disjoint
        List<Integer> warehouseA =
                Arrays.asList(101, 102, 103);

        List<Integer> warehouseB =
                Arrays.asList(201, 202, 203);

        boolean noCommonOrders =
                Collections.disjoint(
                        warehouseA,
                        warehouseB
                );

        System.out.println("\nDo Warehouses Have No Common Orders?");
        System.out.println(noCommonOrders);

        // 12. Shuffle
        Collections.shuffle(processingTimes);

        System.out.println("\nAfter Shuffling:");
        System.out.println(processingTimes);
    }
}