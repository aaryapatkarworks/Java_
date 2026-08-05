import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FoodDeliveryApplication {

    public static void main(String[] args) throws Exception {

        Restaurant restaurant = new Restaurant();

        ExecutorService executor = Executors.newFixedThreadPool(5);

        List<Order> orders = new ArrayList<>();

        // Sample Orders
        orders.add(new Order(101, "Aarya Patkar", 485));
        orders.add(new Order(102, "Pranav More", 620));
        orders.add(new Order(103, "Pratiksha Kulkarni", 395));
        orders.add(new Order(104, "Siddhi Chaudhary", 810));
        orders.add(new Order(105, "Arnav Jadhav", 575));
        orders.add(new Order(106, "Aryan Shetty", 730));
        orders.add(new Order(107, "Nikhil Deshmukh", 455));

        Scanner sc = new Scanner(System.in);

        System.out.println("==========================================");
        System.out.println("      FOOD DELIVERY ORDER SYSTEM");
        System.out.println("==========================================");

        System.out.print("\nDo you want to add more orders? (yes/no): ");
        String choice = sc.nextLine();

        int nextOrderId = 108;

        while (choice.equalsIgnoreCase("yes")) {

            System.out.print("\nEnter Customer Name : ");
            String customerName = sc.nextLine();

            System.out.print("Enter Food Amount (£): ");
            double amount = sc.nextDouble();
            sc.nextLine();

            orders.add(new Order(nextOrderId++, customerName, amount));

            System.out.print("\nAdd another customer? (yes/no): ");
            choice = sc.nextLine();
        }

        List<Future<Double>> bills = new ArrayList<>();

        System.out.println("\n==========================================");
        System.out.println("     PROCESSING CUSTOMER ORDERS...");
        System.out.println("==========================================\n");

        for (Order order : orders) {

            Future<Double> bill =
                    executor.submit(new BillTask(order));

            bills.add(bill);

            executor.submit(new ChefTask(restaurant, order));

            executor.submit(new DeliveryTask(restaurant, order));

        }

        System.out.println("\n============= BILL SUMMARY =============\n");

        for (int i = 0; i < orders.size(); i++) {

            Order order = orders.get(i);

            double foodAmount = order.getFoodAmount();

            double deliveryCharge = 50.0;

            double platformFee = 10.0;

            double gst = foodAmount * 0.05;

            double discount;

            if (foodAmount >= 600) {

                discount = 75.0;

            }

            else {

                discount = 40.0;

            }

            double totalBill = bills.get(i).get();

            System.out.println("--------------------------------------------");
            System.out.println("Customer          : " + order.getCustomerName());
            System.out.println("Order ID          : " + order.getOrderId());

            System.out.printf("Food Amount       : £%.2f%n", foodAmount);
            System.out.printf("Delivery Charge   : £%.2f%n", deliveryCharge);
            System.out.printf("Platform Fee      : £%.2f%n", platformFee);
            System.out.printf("GST (5%%)          : £%.2f%n", gst);
            System.out.printf("Discount          : -£%.2f%n", discount);

            System.out.println("--------------------------------------------");

            System.out.printf("Final Bill        : £%.2f%n", totalBill);

            System.out.println("--------------------------------------------\n");

        }

        executor.shutdown();

        while (!executor.isTerminated()) {

            // Wait until all tasks are completed

        }

        System.out.println("==========================================");
        System.out.println("      DAILY OPERATIONS SUMMARY");
        System.out.println("==========================================");

        System.out.println("Total Orders Processed : " + restaurant.getCompletedOrders());

        System.out.println("Restaurant Status      : CLOSED");

        System.out.println("==========================================");

        sc.close();

    }

}