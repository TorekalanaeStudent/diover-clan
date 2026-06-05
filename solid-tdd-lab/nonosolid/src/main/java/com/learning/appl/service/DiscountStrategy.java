package com.learning.appl.service;

/**
 * DiscountStrategy — SOLID: Open/Closed Principle (OCP) + Polymorphism
 * Open for extension (new discount types), closed for modification.
 * Add new discount types by implementing this interface, never editing existing code.
 */
public interface DiscountStrategy {
    double applyDiscount(double originalPrice);
}
