package com.ovejera.app.grasp.util;

import com.ovejera.app.grasp.entity.Order;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderValidatorTest {

    private final OrderValidator validator =
            new OrderValidator();

    @Test
    void shouldRejectNullOrder() {

        assertFalse(
                validator.isValid(null));
    }

    @Test
    void shouldRejectEmptyOrder() {

        Order order = new Order();

        assertFalse(
                validator.isValid(order));
    }
}