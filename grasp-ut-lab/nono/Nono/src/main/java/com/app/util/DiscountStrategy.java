package com.app.util;

import com.app.entity.Product;

import java.math.BigDecimal;

/**
 * GRASP: Polymorphism + Protected Variations
 * ──────────────────────────────────────────
 * Instead of hard-coding discount logic with if/else chains,
 * we define a stable interface. New discount strategies can be added
 * without touching existing code (Open/Closed Principle).
 *
 * GRASP: Indirection
 * ──────────────────
 * ProductService talks to this interface, NOT to concrete classes.
 * This removes direct coupling between the service and discount logic.
 */
public interface DiscountStrategy {

    /**
     * Computes the final price of the product after applying the discount.
     *
     * @param product the product to price
     * @return discounted price
     */
    BigDecimal apply(Product product);

    /**
     * Human-readable name of the strategy (useful for logging/responses).
     */
    String getName();
}
