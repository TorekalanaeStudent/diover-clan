package com.grasp.jagunap.payment;

// GRASP: Polymorphism - defines a common interface for all payment types
// GRASP: Protected Variations - shields the system from changes in payment methods
public interface Payment {
    void process(double amount);
    String getPaymentType();
}
