package com.obedoza.app.util;


import com.obedoza.app.dto.OrderRequest;
import org.springframework.stereotype.Component;

// GRASP: Pure Fabrication
// This class doesn't map to any real-world concept — it exists purely
// to keep validation logic OUT of the service (High Cohesion).
@Component
public class OrderValidator {

    public void validate(OrderRequest request) {
        if(request.getCustomerName() == null || request.getCustomerName().isBlank()) {
            throw new IllegalArgumentException("Customer name must not be empty");
        }
        if (request.getItems() == null || request.getItems().isEmpty()) {
            throw new IllegalArgumentException("Order must have at least one item");
        }

        request.getItems().forEach(item -> {
            if (item.getQuantity() <= 0) {
                throw new IllegalArgumentException("Quantity must be greater than zero");
            }
            if (item.getUnitPrice() < 0) {
                throw new IllegalArgumentException("Unit price cannot be negative");
            }
        });
    }
}
