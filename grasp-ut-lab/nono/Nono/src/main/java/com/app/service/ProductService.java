package com.app.service;

import com.app.dto.ProductRequest;
import com.app.dto.ProductResponse;
import com.app.entity.Product;
import com.app.exception.ProductNotFoundException;
import com.app.repository.ProductRepository;
import com.app.util.DiscountStrategy;
import com.app.util.ProductMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

/**
 * GRASP: Pure Fabrication
 * ────────────────────────
 * ProductService is not a domain object — it exists to house business logic
 * that does not naturally fit inside an entity or repository.
 *
 * GRASP: Low Coupling
 * ───────────────────
 * Depends on interfaces (ProductRepository, DiscountStrategy) injected by
 * Spring. No hard dependency on concrete implementations — easy to mock in tests.
 *
 * GRASP: High Cohesion
 * ────────────────────
 * Handles ONLY product business logic. No HTTP handling. No SQL.
 */
@Service
@Transactional
public class ProductService {

    // GRASP: Low Coupling — depends on the interface, not JPA internals
    private final ProductRepository productRepository;

    // GRASP: Indirection — talks to DiscountStrategy interface, not concrete class
    private final DiscountStrategy  discountStrategy;

    private final ProductMapper     productMapper;

    public ProductService(ProductRepository productRepository,
                          DiscountStrategy discountStrategy,
                          ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.discountStrategy  = discountStrategy;
        this.productMapper     = productMapper;
    }

    // ── Create ────────────────────────────────────────────────────────────────

    /**
     * Saves a new product.
     * GRASP: Creator — service orchestrates creation using the mapper.
     */
    public ProductResponse createProduct(ProductRequest request) {
        if (productRepository.existsByName(request.getName())) {
            throw new IllegalArgumentException(
                "A product with name '" + request.getName() + "' already exists.");
        }
        Product product = productMapper.toEntity(request);
        Product saved   = productRepository.save(product);
        return productMapper.toResponse(saved);
    }

    // ── Read ──────────────────────────────────────────────────────────────────

    @Transactional(readOnly = true)
    public ProductResponse getProductById(Long id) {
        Product product = findOrThrow(id);
        return productMapper.toResponse(product);
    }

    @Transactional(readOnly = true)
    public List<ProductResponse> getAllProducts() {
        return productRepository.findAll()
                .stream()
                .map(productMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<ProductResponse> getProductsByCategory(String category) {
        return productRepository.findByCategory(category)
                .stream()
                .map(productMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<ProductResponse> getAvailableProducts() {
        return productRepository.findByStockQuantityGreaterThan(0)
                .stream()
                .map(productMapper::toResponse)
                .collect(Collectors.toList());
    }

    // ── Update ────────────────────────────────────────────────────────────────

    public ProductResponse updateProduct(Long id, ProductRequest request) {
        Product product = findOrThrow(id);
        product.setName(request.getName());
        product.setCategory(request.getCategory());
        product.setPrice(request.getPrice());
        product.setStockQuantity(request.getStockQuantity());
        product.setDescription(request.getDescription());
        return productMapper.toResponse(productRepository.save(product));
    }

    // ── Delete ────────────────────────────────────────────────────────────────

    public void deleteProduct(Long id) {
        findOrThrow(id); // ensure it exists before deleting
        productRepository.deleteById(id);
    }

    // ── Business Operations ───────────────────────────────────────────────────

    /**
     * Returns the discounted price for a product using the injected strategy.
     * GRASP: Polymorphism — delegates to DiscountStrategy interface.
     */
    @Transactional(readOnly = true)
    public BigDecimal getDiscountedPrice(Long id) {
        Product product = findOrThrow(id);
        // GRASP: Indirection — goes through the interface, not a concrete class
        return discountStrategy.apply(product);
    }

    /**
     * Sells (deducts) stock for a product.
     * GRASP: Information Expert — deduction logic lives in the entity.
     */
    public ProductResponse sellProduct(Long id, int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than zero");
        }
        Product product = findOrThrow(id);
        product.deductStock(quantity); // entity handles its own stock
        return productMapper.toResponse(productRepository.save(product));
    }

    // ── Internal helper ───────────────────────────────────────────────────────

    private Product findOrThrow(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));
    }
}
