package com.learning.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

interface PaymentServicePrimary {

    void pay();
}

@Component
@Primary
class UPIPaymentPrimary implements PaymentServicePrimary {

    @Override
    public void pay() {
        System.out.println("Payment using UPI");
    }
}

@Component
class CardPaymentPrimary implements PaymentServicePrimary {

    @Override
    public void pay() {
        System.out.println("Payment using Card");
    }
}

@Component
class PaymentProcessorPrimary {

    private final PaymentServicePrimary paymentService;

    public PaymentProcessorPrimary(PaymentServicePrimary paymentService) {
        this.paymentService = paymentService;
    }

    public void process() {
        paymentService.pay();
    }
}

@Configuration
@ComponentScan("com.learning.spring")
class PrimaryConfig {
}

public class _16_PrimaryQualifier {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(PrimaryConfig.class);

        PaymentProcessorPrimary processor =
                context.getBean(PaymentProcessorPrimary.class);

        processor.process();

        context.close();
    }
}