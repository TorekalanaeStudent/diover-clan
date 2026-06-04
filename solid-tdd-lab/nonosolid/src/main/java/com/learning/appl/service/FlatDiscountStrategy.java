package com.learning.appl.service;

/**
 * FlatDiscountStrategy — SOLID: OCP
 * Another implementation of DiscountStrategy, added without modifying existing code.
 * Example: flat ₱50 off → 1000.00 becomes 950.00
 */
public class FlatDiscountStrategy implements DiscountStrategy {

    private final double flatAmount;

    public FlatDiscountStrategy(double flatAmount) {
        if (flatAmount < 0) {
            throw new IllegalArgumentException("Flat discount amount must be non-negative");
        }
        this.flatAmount = flatAmount;
    }

    @Override
    public double applyDiscount(double originalPrice) {
        double result = originalPrice - flatAmount;
        return Math.max(result, 0.0); // never negative
    }

    public double getFlatAmount() { return flatAmount; }
}
