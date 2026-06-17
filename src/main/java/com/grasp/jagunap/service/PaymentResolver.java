package com.grasp.jagunap.service;

import com.grasp.jagunap.payment.Payment;
import org.springframework.stereotype.Component;

import java.util.Map;

// SOLID: OCP - Open for extension (add new payment types) closed for modification
// SOLID: DIP - Depends on Payment interface, not concrete classes
// SOLID: SRP - Only responsible for finding the right payment strategy
@Component
public class PaymentResolver {

    // DIP: Map of abstractions, not concrete implementations
    private final Map<String, Payment> paymentMap;

    public PaymentResolver(Map<String, Payment> paymentMap) {
        this.paymentMap = paymentMap;
    }

    public Payment resolve(String paymentType) {
        if (paymentType == null || paymentType.isBlank()) {
            return null;
        }
        // OCP: Each payment type self-registers via @Component bean name
        // No if-else or switch needed — adding GCASH2 just adds a new class
        String key = paymentType.toLowerCase() + "Payment";
        Payment payment = paymentMap.get(key);
        if (payment == null) {
            throw new IllegalArgumentException("Unknown payment type: " + paymentType);
        }
        return payment;
    }
}