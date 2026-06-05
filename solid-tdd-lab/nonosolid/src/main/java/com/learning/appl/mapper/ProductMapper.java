package com.learning.appl.mapper;

import com.learning.appl.dto.ProductRequest;
import com.learning.appl.dto.ProductResponse;
import com.learning.appl.entity.Product;
import com.learning.appl.service.DiscountStrategy;
import org.springframework.stereotype.Component;

/**
 * ProductMapper — GRASP: Pure Fabrication
 * Does not represent a domain concept; exists purely to map between
 * DTOs and entities. Keeps that logic out of the entity and service.
 *
 * SOLID: SRP — only responsible for mapping.
 */
@Component
public class ProductMapper {

    /**
     * Convert a ProductRequest DTO → Product entity.
     */
    public Product toEntity(ProductRequest request) {
        return new Product(
                request.getName(),
                request.getCategory(),
                request.getPrice(),
                request.getStockQuantity(),
                request.getDescription()
        );
    }

    /**
     * Convert a Product entity → ProductResponse DTO.
     * Applies the discount strategy to compute the discounted price.
     */
    public ProductResponse toResponse(Product product, DiscountStrategy discountStrategy) {
        double discountedPrice = discountStrategy.applyDiscount(product.getPrice());
        return new ProductResponse(
                product.getId(),
                product.getName(),
                product.getCategory(),
                product.getPrice(),
                discountedPrice,
                product.getStockQuantity(),
                product.getDescription(),
                product.isAvailable()
        );
    }
}
