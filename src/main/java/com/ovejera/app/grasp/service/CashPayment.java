package com.ovejera.app.grasp.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class CashPayment implements PaymentStrategy {

    @Override
    public void processPayment(double amount) {
        System.out.println(
                "Processing cash payment: " + amount);
    }
}