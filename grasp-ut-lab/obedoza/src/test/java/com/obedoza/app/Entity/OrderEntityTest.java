package com.obedoza.app.entity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class OrderEntityTest {

    @Test
    void shouldCalculateOrderTotal() {
        Order order = new Order();
        order.addItem("Widget", 2, 10.0); // 2 x $10 = $20
        order.addItem("Gadget", 1, 5.0);  // 1 x $5  = $5

        assertEquals(25.0, order.calculateTotal());
    }
}