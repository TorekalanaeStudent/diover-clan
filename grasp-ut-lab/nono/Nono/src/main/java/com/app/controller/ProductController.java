package com.app.controller;

import com.app.dto.ProductRequest;
import com.app.dto.ProductResponse;
import com.app.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * GRASP: Controller
 * ─────────────────
 * Receives HTTP requests and delegates ALL work to ProductService.
 * Contains ZERO business logic — it only:
 *   1. Validates incoming data (via @Valid)
 *   2. Calls the appropriate service method
 *   3. Wraps the result in an HTTP response
 *
 * GRASP: Low Coupling
 * ───────────────────
 * Only depends on ProductService (injected by Spring).
 */
@RestController
@RequestMapping("/api/products")
public class ProductController {

    // GRASP: Low Coupling — depends on service abstraction
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // ── CRUD Endpoints ────────────────────────────────────────────────────────

    @PostMapping
    public ResponseEntity<ProductResponse> createProduct(
            @Valid @RequestBody ProductRequest request) {
        ProductResponse response = productService.createProduct(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> getProduct(@PathVariable Long id) {
        return ResponseEntity.ok(productService.getProductById(id));
    }

    @GetMapping
    public ResponseEntity<List<ProductResponse>> getAllProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<List<ProductResponse>> getByCategory(
            @PathVariable String category) {
        return ResponseEntity.ok(productService.getProductsByCategory(category));
    }

    @GetMapping("/available")
    public ResponseEntity<List<ProductResponse>> getAvailable() {
        return ResponseEntity.ok(productService.getAvailableProducts());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductResponse> updateProduct(
            @PathVariable Long id,
            @Valid @RequestBody ProductRequest request) {
        return ResponseEntity.ok(productService.updateProduct(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }

    // ── Business Endpoints ────────────────────────────────────────────────────

    /**
     * Returns the discounted price — delegates to service which uses
     * the injected DiscountStrategy (Polymorphism + Indirection).
     */
    @GetMapping("/{id}/discounted-price")
    public ResponseEntity<Map<String, Object>> getDiscountedPrice(@PathVariable Long id) {
        BigDecimal discounted = productService.getDiscountedPrice(id);
        return ResponseEntity.ok(Map.of("productId", id, "discountedPrice", discounted));
    }

    /**
     * Sells a given quantity, deducting stock through the entity
     * (Information Expert GRASP).
     */
    @PostMapping("/{id}/sell")
    public ResponseEntity<ProductResponse> sellProduct(
            @PathVariable Long id,
            @RequestParam int quantity) {
        return ResponseEntity.ok(productService.sellProduct(id, quantity));
    }
}
