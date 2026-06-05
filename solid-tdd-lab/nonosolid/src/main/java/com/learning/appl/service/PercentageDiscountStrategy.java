package com.learning.appl.service;

/**
 * PercentageDiscountStrategy — SOLID: LSP
 * Can substitute DiscountStrategy anywhere without breaking behavior.
 * Example: 10% off → 1000.00 becomes 900.00
 */
public class PercentageDiscountStrategy implements DiscountStrategy {

    private final double percentageOff;

    public PercentageDiscountStrategy(double percentageOff) {
        if (percentageOff < 0 || percentageOff > 100) {
            throw new IllegalArgumentException("Percentage must be between 0 and 100");
        }
        this.percentageOff = percentageOff;
    }

    @Override
    public double applyDiscount(double originalPrice) {
        return originalPrice - (originalPrice * percentageOff / 100.0);
    }

    public double getPercentageOff() { return percentageOff; }
}
