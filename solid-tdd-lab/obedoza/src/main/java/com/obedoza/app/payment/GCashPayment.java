package com.obedoza.app.payment;

import org.springframework.stereotype.Component;

@Component("Gcash")
public class GCashPayment implements PaymentProcessor{
    @Override
    public void process(double amount) {
        System.out.println("Processing GCash payment of $" + amount);
    }

    @Override
    public String getPaymentType() {
        return "GCASH";
    }
}
