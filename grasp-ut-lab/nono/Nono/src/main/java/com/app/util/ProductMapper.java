package com.app.util;

import com.app.dto.ProductRequest;
import com.app.dto.ProductResponse;
import com.app.entity.Product;
import org.springframework.stereotype.Component;

/**
 * GRASP: Pure Fabrication
 * ────────────────────────
 * ProductMapper has no counterpart in the real-world domain.
 * It exists purely to keep mapping logic out of both the entity (which
 * should not know about DTOs) and the service (which should focus on
 * business rules). A fabricated helper with high cohesion.
 *
 * GRASP: High Cohesion
 * ────────────────────
 * This class has ONE responsibility: convert between Product and its DTOs.
 */
@Component
public class ProductMapper {

    /**
     * Converts a ProductRequest DTO → Product entity.
     * GRASP: Creator — ProductMapper creates Product because it has the data.
     */
    public Product toEntity(ProductRequest request) {
        Product product = new Product();
        product.setName(request.getName());
        product.setCategory(request.getCategory());
        product.setPrice(request.getPrice());
        product.setStockQuantity(request.getStockQuantity());
        product.setDescription(request.getDescription());
        return product;
    }

    /**
     * Converts a Product entity → ProductResponse DTO.
     */
    public ProductResponse toResponse(Product product) {
        ProductResponse response = new ProductResponse();
        response.setId(product.getId());
        response.setName(product.getName());
        response.setCategory(product.getCategory());
        response.setPrice(product.getPrice());
        response.setStockQuantity(product.getStockQuantity());
        response.setDescription(product.getDescription());
        // GRASP: Information Expert — ask the entity if it's available
        response.setAvailable(product.isAvailable(1));
        return response;
    }
}
