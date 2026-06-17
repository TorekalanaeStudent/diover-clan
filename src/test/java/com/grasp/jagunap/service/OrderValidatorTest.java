package com.grasp.jagunap.service;

import com.grasp.jagunap.dto.CreateOrderRequest;
import com.grasp.jagunap.dto.OrderItemDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Collections;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class OrderValidatorTest {

    private OrderValidator validator;

    @BeforeEach
    void setUp() { validator = new OrderValidator(); }

    @Test
    void shouldPassValidRequest() {
        CreateOrderRequest req = new CreateOrderRequest();
        req.setCustomerName("Juan");
        req.setItems(List.of(new OrderItemDTO(null, "Item", 10.0, 1)));
        assertDoesNotThrow(() -> validator.validate(req));
    }

    @Test
    void shouldThrowWhenNameIsNull() {
        CreateOrderRequest req = new CreateOrderRequest();
        req.setCustomerName(null);
        req.setItems(List.of(new OrderItemDTO(null, "Item", 10.0, 1)));
        assertThrows(IllegalArgumentException.class, () -> validator.validate(req));
    }

    @Test
    void shouldThrowWhenNameIsBlank() {
        CreateOrderRequest req = new CreateOrderRequest();
        req.setCustomerName("   ");
        req.setItems(List.of(new OrderItemDTO(null, "Item", 10.0, 1)));
        assertThrows(IllegalArgumentException.class, () -> validator.validate(req));
    }

    @Test
    void shouldThrowWhenItemsAreEmpty() {
        CreateOrderRequest req = new CreateOrderRequest();
        req.setCustomerName("Juan");
        req.setItems(Collections.emptyList());
        assertThrows(IllegalArgumentException.class, () -> validator.validate(req));
    }

    @Test
    void shouldThrowWhenItemsAreNull() {
        CreateOrderRequest req = new CreateOrderRequest();
        req.setCustomerName("Juan");
        req.setItems(null);
        assertThrows(IllegalArgumentException.class, () -> validator.validate(req));
    }
}