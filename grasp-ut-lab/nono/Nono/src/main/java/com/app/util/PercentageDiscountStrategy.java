package com.app.util;

import com.app.entity.Product;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * GRASP: Polymorphism
 * ───────────────────
 * First concrete implementation of DiscountStrategy.
 * Applies a percentage off the product's price.
 *
 * GRASP: High Cohesion
 * ────────────────────
 * This class has ONE job: compute a percentage-based discount.
 */
@Component("percentageDiscount")
public class PercentageDiscountStrategy implements DiscountStrategy {

    private final double percent;

    public PercentageDiscountStrategy() {
        this.percent = 10.0; // default 10 %
    }

    public PercentageDiscountStrategy(double percent) {
        if (percent < 0 || percent > 100) {
            throw new IllegalArgumentException("Percent must be 0–100");
        }
        this.percent = percent;
    }

    @Override
    public BigDecimal apply(Product product) {
        // GRASP: Information Expert — delegates calculation to the entity
        return product.calculateDiscountedPrice(percent);
    }

    @Override
    public String getName() {
        return "PERCENTAGE_" + percent + "%";
    }
}
