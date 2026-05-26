package com.obedoza.app.util;

import com.obedoza.app.dto.OrderRequest;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class OrderValidatorTest {

    private final OrderValidator validator = new OrderValidator();

    @Test
    void shouldPassValidRequest() {
        OrderRequest.ItemRequest item = new OrderRequest.ItemRequest("Widget", 1, 5.0);
        OrderRequest request = new OrderRequest("Alice", List.of(item));
        assertDoesNotThrow(() -> validator.validate(request));
    }

    @Test
    void shouldFailWhenCustomerNameIsBlank() {
        OrderRequest request = new OrderRequest("", List.of(
                new OrderRequest.ItemRequest("Widget", 1, 5.0)
        ));
        assertThrows(IllegalArgumentException.class, () -> validator.validate(request));
    }

    @Test
    void shouldFailWhenItemListIsEmpty() {
        OrderRequest request = new OrderRequest("Alice", Collections.emptyList());
        assertThrows(IllegalArgumentException.class, () -> validator.validate(request));
    }

    @Test
    void shouldFailWhenQuantityIsZero() {
        OrderRequest request = new OrderRequest("Alice", List.of(
                new OrderRequest.ItemRequest("Widget", 0, 5.0)
        ));
        assertThrows(IllegalArgumentException.class, () -> validator.validate(request));
    }
}
