package com.obedoza.app.payment;

import org.springframework.stereotype.Component;

// GRASP: Polymorphism — concrete implementation #1
@Component("CreditCard")
public class CreditCardPayment implements PaymentProcessor {

    @Override
    public void process(double amount) {
        System.out.println("Processing credit card payment of $" + amount);
    }

    @Override
    public String getPaymentType() {
        return "CREDIT_CARD";
    }
}
