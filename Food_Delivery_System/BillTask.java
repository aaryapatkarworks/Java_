import java.util.concurrent.Callable;

public class BillTask implements Callable<Double> {

    private final Order order;

    public BillTask(Order order) {

        this.order = order;

    }

    @Override
    public Double call() throws Exception {

        Thread.sleep(1000);

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

        return foodAmount
                + deliveryCharge
                + platformFee
                + gst
                - discount;

    }

}