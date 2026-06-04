package com.grasp.jagunap.util;

import com.grasp.jagunap.entity.Order;
import com.grasp.jagunap.entity.OrderItem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderCalculatorTest {

    private OrderCalculator calculator;
    private Order order;

    @BeforeEach
    void setUp() {
        calculator = new OrderCalculator();
        order = new Order("Test Customer");
        order.addItem(new OrderItem("Item A", 100.0, 2)); // 200
        order.addItem(new OrderItem("Item B", 50.0, 2));  // 100
        // total = 300
    }

    @Test
    void shouldCalculateDiscountCorrectly() {
        double result = calculator.calculateDiscount(order, 10.0);
        assertEquals(270.0, result);
    }

    @Test
    void shouldReturnFullAmountWhenNoDiscount() {
        double result = calculator.calculateDiscount(order, 0.0);
        assertEquals(300.0, result);
    }

    @Test
    void shouldThrowWhenDiscountIsNegative() {
        assertThrows(IllegalArgumentException.class,
                () -> calculator.calculateDiscount(order, -5.0));
    }

    @Test
    void shouldThrowWhenDiscountExceeds100() {
        assertThrows(IllegalArgumentException.class,
                () -> calculator.calculateDiscount(order, 101.0));
    }

    @Test
    void shouldCalculateTaxCorrectly() {
        double tax = calculator.calculateTax(order, 0.12); // 12% VAT
        assertEquals(36.0, tax);
    }

    @Test
    void shouldThrowWhenTaxRateIsNegative() {
        assertThrows(IllegalArgumentException.class,
                () -> calculator.calculateTax(order, -0.1));
    }

    @Test
    void shouldCalculateFinalAmountWithDiscountAndTax() {
        // 300 - 10% = 270, + 12% tax = 270 + 32.4 = 302.4
        double result = calculator.calculateFinalAmount(order, 10.0, 0.12);
        assertEquals(302.4, result, 0.01);
    }
}
