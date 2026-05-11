package com.learning.appl.util;

import com.learning.appl.dto.OrderRequest;
import com.learning.appl.exception.InvalidOrderException;
import org.springframework.stereotype.Component;

/**
 * GRASP: Pure Fabrication
 * OrderValidator has no real-world counterpart; it exists to keep validation
 *
 * GRASP: High Cohesion
 * This class has one and only one responsibility: validate an OrderRequest.
 */
@Component
public class OrderValidator {

    public void validate(OrderRequest request) {
        if (request == null) {
            throw new InvalidOrderException("Order request must not be null");
        }
        if (request.getCustomerName() == null || request.getCustomerName().isBlank()) {
            throw new InvalidOrderException("Customer name is required");
        }
        if (request.getItems() == null || request.getItems().isEmpty()) {
            throw new InvalidOrderException("Order must contain at least one item");
        }
        for (OrderRequest.OrderItemRequest item : request.getItems()) {
            if (item.getQuantity() < 1) {
                throw new InvalidOrderException(
                        "Item quantity must be >= 1: " + item.getProductName());
            }
            if (item.getUnitPrice() < 0) {
                throw new InvalidOrderException(
                        "Item price must be >= 0: " + item.getProductName());
            }
        }
    }
}