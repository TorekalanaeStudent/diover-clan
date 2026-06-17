package com.grasp.jagunap.payment;

import org.springframework.stereotype.Component;

// GRASP: Polymorphism - third implementation, extensible without modifying others
// GRASP: Protected Variations - system is protected from changes in payment methods
@Component("gcashPayment")
public class GcashPayment implements Payment {

    @Override
    public void process(double amount) {
        // GRASP: High Cohesion - only handles GCash payment logic
        System.out.println("Processing GCASH payment of: " + amount);
    }

    @Override
    public String getPaymentType() {
        return "GCASH";
    }
}
