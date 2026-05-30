package com.app.util;

import com.app.entity.Product;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.*;

/**
 * Tests for DiscountStrategy implementations and Product entity logic.
 *
 * GRASP validated:
 *  - Polymorphism      : both strategies are tested through the same interface
 *  - Information Expert: Product's own calculations are verified
 *  - Protected Variations: adding a new strategy requires no change here
 */
class DiscountStrategyTest {

    private Product makeProduct(double price, int stock) {
        return new Product("Test", "Cat", BigDecimal.valueOf(price), stock);
    }

    // ═════════════════════════════════════════════════════════════════════════
    // GRASP: Polymorphism — test both strategies via the interface
    // ═════════════════════════════════════════════════════════════════════════

    @Test
    @DisplayName("PercentageDiscountStrategy applies correct discount")
    void percentageStrategy_shouldApplyDiscount() {
        DiscountStrategy strategy = new PercentageDiscountStrategy(10.0);
        Product product = makeProduct(100.00, 5);

        BigDecimal result = strategy.apply(product);

        assertThat(result).isEqualByComparingTo("90.00");
    }

    @Test
    @DisplayName("FlatDiscountStrategy subtracts fixed amount")
    void flatStrategy_shouldSubtractFlatAmount() {
        DiscountStrategy strategy = new FlatDiscountStrategy(new BigDecimal("15.00"));
        Product product = makeProduct(100.00, 5);

        BigDecimal result = strategy.apply(product);

        assertThat(result).isEqualByComparingTo("85.00");
    }

    @Test
    @DisplayName("FlatDiscountStrategy floors at zero — never negative")
    void flatStrategy_shouldNotGoNegative() {
        DiscountStrategy strategy = new FlatDiscountStrategy(new BigDecimal("200.00"));
        Product product = makeProduct(50.00, 5);

        BigDecimal result = strategy.apply(product);

        assertThat(result).isEqualByComparingTo("0.00");
    }

    @Test
    @DisplayName("PercentageDiscountStrategy with 0 % returns original price")
    void percentageStrategy_zeroPercent_returnsOriginal() {
        DiscountStrategy strategy = new PercentageDiscountStrategy(0.0);
        Product product = makeProduct(250.00, 3);

        assertThat(strategy.apply(product)).isEqualByComparingTo("250.00");
    }

    @Test
    @DisplayName("PercentageDiscountStrategy with 100 % returns zero")
    void percentageStrategy_fullDiscount_returnsZero() {
        DiscountStrategy strategy = new PercentageDiscountStrategy(100.0);
        Product product = makeProduct(100.00, 3);

        assertThat(strategy.apply(product)).isEqualByComparingTo("0.00");
    }

    @Test
    @DisplayName("Invalid percentage throws IllegalArgumentException")
    void percentageStrategy_invalidPercent_throws() {
        assertThatThrownBy(() -> new PercentageDiscountStrategy(-5))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new PercentageDiscountStrategy(101))
                .isInstanceOf(IllegalArgumentException.class);
    }

    // ═════════════════════════════════════════════════════════════════════════
    // GRASP: Information Expert — Product knows its own business rules
    // ═════════════════════════════════════════════════════════════════════════

    @Test
    @DisplayName("Product.isAvailable returns true when stock is sufficient")
    void product_isAvailable_trueWhenSufficient() {
        Product p = makeProduct(10.00, 5);
        assertThat(p.isAvailable(3)).isTrue();
        assertThat(p.isAvailable(5)).isTrue();
    }

    @Test
    @DisplayName("Product.isAvailable returns false when stock is insufficient")
    void product_isAvailable_falseWhenInsufficient() {
        Product p = makeProduct(10.00, 2);
        assertThat(p.isAvailable(3)).isFalse();
    }

    @Test
    @DisplayName("Product.deductStock reduces quantity correctly")
    void product_deductStock_reducesQuantity() {
        Product p = makeProduct(10.00, 10);
        p.deductStock(4);
        assertThat(p.getStockQuantity()).isEqualTo(6);
    }

    @Test
    @DisplayName("Product.deductStock throws when stock is insufficient")
    void product_deductStock_throwsWhenInsufficient() {
        Product p = makeProduct(10.00, 2);
        assertThatThrownBy(() -> p.deductStock(5))
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("Insufficient stock");
    }

    @Test
    @DisplayName("Product.calculatePriceWithTax applies tax correctly")
    void product_calculatePriceWithTax() {
        Product p = makeProduct(100.00, 1);
        assertThat(p.calculatePriceWithTax(0.12)).isEqualByComparingTo("112.00");
    }

    @Test
    @DisplayName("Product.calculatePriceWithTax throws for negative tax")
    void product_calculatePriceWithTax_negativeThrows() {
        Product p = makeProduct(100.00, 1);
        assertThatThrownBy(() -> p.calculatePriceWithTax(-0.1))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
