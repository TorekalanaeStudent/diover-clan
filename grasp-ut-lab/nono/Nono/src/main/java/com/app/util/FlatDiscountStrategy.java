package com.app.util;

import com.app.entity.Product;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * GRASP: Polymorphism
 * ───────────────────
 * Second concrete implementation of DiscountStrategy.
 * Subtracts a fixed amount from the product's price (floor at 0).
 *
 * GRASP: High Cohesion
 * ────────────────────
 * This class has ONE job: compute a flat-amount discount.
 *
 * GRASP: Protected Variations
 * ────────────────────────────
 * Adding this new strategy required ZERO changes to ProductService —
 * the interface absorbed the variation.
 */
@Component("flatDiscount")
public class FlatDiscountStrategy implements DiscountStrategy {

    private final BigDecimal flatAmount;

    public FlatDiscountStrategy() {
        this.flatAmount = BigDecimal.valueOf(5.00); // default ₱5 off
    }

    public FlatDiscountStrategy(BigDecimal flatAmount) {
        if (flatAmount.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Flat amount must be non-negative");
        }
        this.flatAmount = flatAmount;
    }

    @Override
    public BigDecimal apply(Product product) {
        BigDecimal discounted = product.getPrice().subtract(flatAmount);
        // Price must never go below zero
        return discounted.max(BigDecimal.ZERO).setScale(2, RoundingMode.HALF_UP);
    }

    @Override
    public String getName() {
        return "FLAT_" + flatAmount;
    }
}
