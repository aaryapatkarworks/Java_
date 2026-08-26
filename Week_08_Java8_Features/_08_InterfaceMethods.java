interface PaymentService {

    void processPayment();

    // Default method
    default void generateReceipt() {
        System.out.println("Generating standard payment receipt...");
    }

    // Static method
    static void showPaymentGateway() {
        System.out.println("Secure Payment Gateway");
    }
}

class UPIService implements PaymentService {

    @Override
    public void processPayment() {
        System.out.println("Processing UPI payment...");
    }

    // Overriding the default method
    @Override
    public void generateReceipt() {
        System.out.println("Generating UPI payment receipt...");
    }
}

public class _08_InterfaceMethods {

    public static void main(String[] args) {

        UPIService payment = new UPIService();

        payment.processPayment();

        payment.generateReceipt();

        PaymentService.showPaymentGateway();
    }
}