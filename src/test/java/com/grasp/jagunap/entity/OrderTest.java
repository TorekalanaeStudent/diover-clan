package com.grasp.jagunap.entity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

// GRASP: Information Expert — verifies Order calculates its own total
class OrderTest {

    @Test
    void shouldCalculateTotalCorrectly() {
        Order order = new Order("Janelle");
        order.addItem("Pen", 10.0, 3);      // 30.0
        order.addItem("Notebook", 50.0, 1); // 50.0

        assertEquals(80.0, order.calculateTotal(), 0.001);
    }

    @Test
    void shouldReturnZeroTotalForEmptyOrder() {
        Order order = new Order("Janelle");
        assertEquals(0.0, order.calculateTotal(), 0.001);
    }

    @Test
    void shouldSetStatusToPendingOnCreation() {
        Order order = new Order("Janelle");
        assertEquals("PENDING", order.getStatus());
    }
}