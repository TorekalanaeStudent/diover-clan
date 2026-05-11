package com.learning.appl.payment;

import org.springframework.stereotype.Component;
import java.util.UUID;

/**
 * GRASP: Polymorphism — concrete implementation of PaymentProcessor.
 * GRASP: High Cohesion — only handles credit-card payment logic.
 */
@Component
public class CreditCardPaymentProcessor implements PaymentProcessor {

    @Override
    public String process(double amount) {
        // In production: integrate with a real credit-card gateway here
        String txId = "CC-" + UUID.randomUUID();
        System.out.printf("[CreditCard] Charged $%.2f  txId=%s%n", amount, txId);
        return txId;
    }

    @Override
    public String getMethodKey() {
        return "CREDIT_CARD";
    }
}