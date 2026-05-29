package com.obedoza.app.payment;

import org.springframework.stereotype.Component;

// GRASP: Polymorphism — concrete implementation #2
@Component("Cash")
public class CashPayment implements PaymentProcessor {

    @Override
    public void process(double amount) {
        System.out.println("Processing cash payment of $" + amount);
    }

    @Override
    public String getPaymentType() {
        return "CASH";
    }
}
