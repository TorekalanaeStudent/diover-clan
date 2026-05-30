package com.ovejera.app.grasp.service;

import org.springframework.stereotype.Service;

// GRASP: Polymorphism
@Service
public class CreditCardPayment implements PaymentStrategy {

    @Override
    public void processPayment(double amount) {

        System.out.println(
                "Processing credit card payment: " + amount);

    }
}