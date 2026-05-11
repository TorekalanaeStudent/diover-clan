package com.learning.appl.payment;

import org.springframework.stereotype.Component;
import java.util.UUID;

/**
 * GRASP: Polymorphism — second concrete PaymentProcessor implementation.
 * GRASP: High Cohesion — responsible for PayPal payment logic.
 */
@Component
public class PayPalPaymentProcessor implements PaymentProcessor {

    @Override
    public String process(double amount) {
        String txId = "PP-" + UUID.randomUUID();
        System.out.printf("[PayPal] Charged $%.2f  txId=%s%n", amount, txId);
        return txId;
    }

    @Override
    public String getMethodKey() {
        return "PAYPAL";
    }
}