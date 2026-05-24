package com.learning.appl.util;

import com.learning.appl.dto.OrderRequest;
import com.learning.appl.exception.InvalidOrderException;
import org.springframework.stereotype.Component;

/**
 * GRASP: Pure Fabrication - validation is kept out of controllers and entities.
 *
 * SOLID: SRP - handles only order request validation.
 * KISS/YAGNI - validates the rules currently used by the order flow only.
 */
@Component
public class OrderValidator {

    public void validate(OrderRequest request) {
        if (request == null) {
            throw new InvalidOrderException("Order request must not be null");
        }
        if (isBlank(request.getCustomerName())) {
            throw new InvalidOrderException("Customer name is required");
        }
        if (isBlank(request.getPaymentMethod())) {
            throw new InvalidOrderException("Payment method is required");
        }
        if (request.getItems() == null || request.getItems().isEmpty()) {
            throw new InvalidOrderException("Order must contain at least one item");
        }
        for (OrderRequest.OrderItemRequest item : request.getItems()) {
            validateItem(item);
        }
    }

    private void validateItem(OrderRequest.OrderItemRequest item) {
        if (item == null) {
            throw new InvalidOrderException("Order item must not be null");
        }
        if (isBlank(item.getProductName())) {
            throw new InvalidOrderException("Item product name is required");
        }
        if (item.getQuantity() < 1) {
            throw new InvalidOrderException(
                    "Item quantity must be >= 1: " + item.getProductName());
        }
        if (item.getUnitPrice() < 0) {
            throw new InvalidOrderException(
                    "Item price must be >= 0: " + item.getProductName());
        }
    }

    // DRY: Shared reusable validation method for blank text checks.
    private boolean isBlank(String value) {
        return value == null || value.isBlank();
    }
}
