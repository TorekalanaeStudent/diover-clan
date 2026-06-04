package com.learning.appl.service;

import com.learning.appl.dto.ProductRequest;
import com.learning.appl.dto.ProductResponse;
import com.learning.appl.entity.Product;
import com.learning.appl.entity.ProductSnapshot;
import com.learning.appl.exceptions.ProductNotFoundException;
import com.learning.appl.mapper.ProductMapper;
import com.learning.appl.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ProductService — GRASP: Pure Fabrication, Low Coupling, High Cohesion
 * SOLID:
 *   SRP — only orchestrates product operations (validation/mapping extracted)
 *   OCP — discount/notification strategy injected; adding new ones = zero edits here
 *   DIP — depends on DiscountStrategy and Notifier interfaces, not concrete classes
 */
@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private final DiscountStrategy discountStrategy;
    private final Notifier notifier;
    private final ProductValidator productValidator;

    // Constructor injection — DIP in action
    public ProductService(ProductRepository productRepository,
                          ProductMapper productMapper,
                          DiscountStrategy discountStrategy,
                          Notifier notifier,
                          ProductValidator productValidator) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
        this.discountStrategy = discountStrategy;
        this.notifier = notifier;
        this.productValidator = productValidator;
    }

    public List<ProductResponse> getAllProducts() {
        return productRepository.findAll()
                .stream()
                .map(p -> productMapper.toResponse(p, discountStrategy))
                .toList();
    }

    public ProductResponse getProductById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));
        return productMapper.toResponse(product, discountStrategy);
    }

    public ProductResponse createProduct(ProductRequest request) {
        productValidator.validate(request);           // SRP: delegate to validator
        Product product = productMapper.toEntity(request);
        Product saved = productRepository.save(product);
        notifier.notify("New product created: " + saved.getName()); // DIP: interface
        return productMapper.toResponse(saved, discountStrategy);
    }

    public ProductResponse updateProduct(Long id, ProductRequest request) {
        productValidator.validate(request);
        Product existing = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));
        existing.setName(request.getName());
        existing.setCategory(request.getCategory());
        existing.setPrice(request.getPrice());
        existing.setStockQuantity(request.getStockQuantity());
        existing.setDescription(request.getDescription());
        Product updated = productRepository.save(existing);
        notifier.notify("Product updated: " + updated.getName());
        return productMapper.toResponse(updated, discountStrategy);
    }

    public void deleteProduct(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));
        productRepository.delete(product);
        notifier.notify("Product deleted: " + product.getName());
    }

    public ProductSnapshot snapshotProduct(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));
        return ProductSnapshot.from(product); // Immutability in action
    }

    public List<ProductResponse> getAvailableProducts() {
        return productRepository.findByStockQuantityGreaterThan(0)
                .stream()
                .map(p -> productMapper.toResponse(p, discountStrategy))
                .toList();
    }
}
