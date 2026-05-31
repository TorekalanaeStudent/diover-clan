package com.obedoza.app.payment;

// GRASP: Polymorphism
// Define a common interface so multiple payment types can be used interchangeably

// GRASP: Protected Variations
// If a new payment method is added, no existing code changes — just add a new implimentation
public interface PaymentProcessor {
    void process(double amount);
    String getPaymentType();
}
