package com.learning.appl.service;

import com.learning.appl.dto.ProductRequest;
import org.springframework.stereotype.Component;

/**
 * ProductValidator — SOLID: SRP (Single Responsibility Principle)
 * Extracted from ProductService. This class has ONE job: validate product data.
 * Before SRP: validation lived inside ProductService (multiple responsibilities).
 * After SRP: ProductService delegates to ProductValidator.
 */
@Component
public class ProductValidator {

    /**
     * Validates a ProductRequest and throws IllegalArgumentException if invalid.
     */
    public void validate(ProductRequest request) {
        if (request == null) {
            throw new IllegalArgumentException("Product request cannot be null");
        }
        if (request.getName() == null || request.getName().isBlank()) {
            throw new IllegalArgumentException("Product name cannot be empty");
        }
        if (request.getCategory() == null || request.getCategory().isBlank()) {
            throw new IllegalArgumentException("Product category cannot be empty");
        }
        if (request.getPrice() == null || request.getPrice() < 0) {
            throw new IllegalArgumentException("Product price must be non-negative");
        }
        if (request.getStockQuantity() < 0) {
            throw new IllegalArgumentException("Stock quantity must be non-negative");
        }
    }
}
