package com.grasp.jagunap.service;

import com.grasp.jagunap.dto.CreateOrderRequest;
import org.springframework.stereotype.Component;

// SOLID: SRP - This class has ONE job: validate order requests
// SOLID: DIP - OrderService depends on this abstraction via constructor injection
// DRY: Centralized validation — not repeated across multiple service methods
@Component
public class OrderValidator {

    public void validate(CreateOrderRequest request) {
        // DRY: Shared reusable validation method
        if (request.getCustomerName() == null || request.getCustomerName().isBlank()) {
            throw new IllegalArgumentException("Customer name cannot be empty");
        }
        if (request.getItems() == null || request.getItems().isEmpty()) {
            throw new IllegalArgumentException("Order must have at least one item");
        }
    }
}