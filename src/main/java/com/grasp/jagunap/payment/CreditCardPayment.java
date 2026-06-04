package com.grasp.jagunap.payment;

import org.springframework.stereotype.Component;

// GRASP: Polymorphism - another concrete implementation of Payment
// GRASP: Protected Variations - new payment type added without changing existing code
@Component("creditCardPayment")
public class CreditCardPayment implements Payment {

    @Override
    public void process(double amount) {
        // GRASP: High Cohesion - only handles credit card payment logic
        System.out.println("Processing CREDIT CARD payment of: " + amount);
    }

    @Override
    public String getPaymentType() {
        return "CREDIT_CARD";
    }
}
