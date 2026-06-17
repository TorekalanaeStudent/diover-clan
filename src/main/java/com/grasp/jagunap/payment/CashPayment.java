package com.grasp.jagunap.payment;

import org.springframework.stereotype.Component;

// GRASP: Polymorphism - concrete implementation of Payment interface
@Component("cashPayment")
public class CashPayment implements Payment {

    @Override
    public void process(double amount) {
        // GRASP: High Cohesion - this class only handles cash payment logic
        System.out.println("Processing CASH payment of: " + amount);
    }

    @Override
    public String getPaymentType() {
        return "CASH";
    }
}
