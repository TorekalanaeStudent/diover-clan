package com.grasp.jagunap.util;

import com.grasp.jagunap.entity.Order;
import org.springframework.stereotype.Component;

// GRASP: Pure Fabrication - this class doesn't represent a real-world concept
// It exists purely to support reusable calculation logic (doesn't pollute Order entity)
// GRASP: High Cohesion - only responsible for order-related calculations
@Component
public class OrderCalculator {

    // GRASP: Pure Fabrication - utility method that doesn't belong to any domain object
    public double calculateDiscount(Order order, double discountPercent) {
        if (discountPercent < 0 || discountPercent > 100) {
            throw new IllegalArgumentException("Discount must be between 0 and 100");
        }
        double total = order.calculateTotal();
        return total - (total * discountPercent / 100);
    }

    public double calculateTax(Order order, double taxRate) {
        if (taxRate < 0) {
            throw new IllegalArgumentException("Tax rate cannot be negative");
        }
        return order.calculateTotal() * taxRate;
    }

    public double calculateFinalAmount(Order order, double discountPercent, double taxRate) {
        double discountedTotal = calculateDiscount(order, discountPercent);
        double tax = discountedTotal * taxRate;
        return discountedTotal + tax;
    }
}
