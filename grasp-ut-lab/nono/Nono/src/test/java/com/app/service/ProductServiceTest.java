package com.app.service;

import com.app.dto.ProductRequest;
import com.app.dto.ProductResponse;
import com.app.entity.Product;
import com.app.exception.ProductNotFoundException;
import com.app.repository.ProductRepository;
import com.app.util.DiscountStrategy;
import com.app.util.PercentageDiscountStrategy;
import com.app.util.ProductMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

/**
 * Unit tests for ProductService.
 *
 * GRASP validated:
 *  - Pure Fabrication  : service is tested in isolation (no Spring context)
 *  - Low Coupling      : dependencies are mocked — no real DB calls
 *  - Polymorphism      : DiscountStrategy is injected as an interface mock
 */
@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    // ── Mocks (GRASP: Low Coupling — depend on interfaces) ───────────────────
    @Mock private ProductRepository productRepository;
    @Mock private DiscountStrategy   discountStrategy;
    @Mock private ProductMapper      productMapper;

    @InjectMocks
    private ProductService productService;

    // ── Helpers ───────────────────────────────────────────────────────────────

    private Product sampleProduct() {
        Product p = new Product("Laptop", "Electronics", new BigDecimal("999.99"), 10);
        p.setId(1L);
        return p;
    }

    private ProductRequest sampleRequest() {
        ProductRequest r = new ProductRequest();
        r.setName("Laptop");
        r.setCategory("Electronics");
        r.setPrice(new BigDecimal("999.99"));
        r.setStockQuantity(10);
        return r;
    }

    private ProductResponse sampleResponse(Product p) {
        ProductResponse res = new ProductResponse();
        res.setId(p.getId());
        res.setName(p.getName());
        res.setCategory(p.getCategory());
        res.setPrice(p.getPrice());
        res.setStockQuantity(p.getStockQuantity());
        res.setAvailable(true);
        return res;
    }

    // ═════════════════════════════════════════════════════════════════════════
    // CREATE
    // ═════════════════════════════════════════════════════════════════════════

    @Test
    @DisplayName("Should create a product successfully")
    void shouldCreateProduct() {
        // Arrange
        ProductRequest  request  = sampleRequest();
        Product         entity   = sampleProduct();
        ProductResponse response = sampleResponse(entity);

        when(productRepository.existsByName("Laptop")).thenReturn(false);
        when(productMapper.toEntity(request)).thenReturn(entity);
        when(productRepository.save(entity)).thenReturn(entity);
        when(productMapper.toResponse(entity)).thenReturn(response);

        // Act
        ProductResponse result = productService.createProduct(request);

        // Assert
        assertThat(result).isNotNull();
        assertThat(result.getName()).isEqualTo("Laptop");
        verify(productRepository).save(entity);
    }

    @Test
    @DisplayName("Should throw when product name already exists")
    void shouldThrowWhenDuplicateName() {
        // Arrange
        ProductRequest request = sampleRequest();
        when(productRepository.existsByName("Laptop")).thenReturn(true);

        // Act & Assert
        assertThatThrownBy(() -> productService.createProduct(request))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("already exists");

        verify(productRepository, never()).save(any());
    }

    // ═════════════════════════════════════════════════════════════════════════
    // READ
    // ═════════════════════════════════════════════════════════════════════════

    @Test
    @DisplayName("Should return product by ID")
    void shouldReturnProductById() {
        Product         entity   = sampleProduct();
        ProductResponse response = sampleResponse(entity);

        when(productRepository.findById(1L)).thenReturn(Optional.of(entity));
        when(productMapper.toResponse(entity)).thenReturn(response);

        ProductResponse result = productService.getProductById(1L);

        assertThat(result.getId()).isEqualTo(1L);
        assertThat(result.getName()).isEqualTo("Laptop");
    }

    @Test
    @DisplayName("Should throw ProductNotFoundException for unknown ID")
    void shouldThrowForUnknownId() {
        when(productRepository.findById(99L)).thenReturn(Optional.empty());

        assertThatThrownBy(() -> productService.getProductById(99L))
                .isInstanceOf(ProductNotFoundException.class)
                .hasMessageContaining("99");
    }

    @Test
    @DisplayName("Should return empty list when no products exist")
    void shouldReturnEmptyListWhenNoProducts() {
        when(productRepository.findAll()).thenReturn(Collections.emptyList());

        List<ProductResponse> result = productService.getAllProducts();

        assertThat(result).isEmpty();
    }

    @Test
    @DisplayName("Should return products filtered by category")
    void shouldReturnProductsByCategory() {
        Product         entity   = sampleProduct();
        ProductResponse response = sampleResponse(entity);

        when(productRepository.findByCategory("Electronics")).thenReturn(List.of(entity));
        when(productMapper.toResponse(entity)).thenReturn(response);

        List<ProductResponse> result = productService.getProductsByCategory("Electronics");

        assertThat(result).hasSize(1);
        assertThat(result.get(0).getCategory()).isEqualTo("Electronics");
    }

    // ═════════════════════════════════════════════════════════════════════════
    // UPDATE
    // ═════════════════════════════════════════════════════════════════════════

    @Test
    @DisplayName("Should update an existing product")
    void shouldUpdateProduct() {
        Product         entity   = sampleProduct();
        ProductRequest  request  = sampleRequest();
        request.setName("Gaming Laptop");
        ProductResponse response = sampleResponse(entity);
        response.setName("Gaming Laptop");

        when(productRepository.findById(1L)).thenReturn(Optional.of(entity));
        when(productRepository.save(entity)).thenReturn(entity);
        when(productMapper.toResponse(entity)).thenReturn(response);

        ProductResponse result = productService.updateProduct(1L, request);

        assertThat(result.getName()).isEqualTo("Gaming Laptop");
        verify(productRepository).save(entity);
    }

    // ═════════════════════════════════════════════════════════════════════════
    // DELETE
    // ═════════════════════════════════════════════════════════════════════════

    @Test
    @DisplayName("Should delete product by ID")
    void shouldDeleteProduct() {
        Product entity = sampleProduct();
        when(productRepository.findById(1L)).thenReturn(Optional.of(entity));

        productService.deleteProduct(1L);

        verify(productRepository).deleteById(1L);
    }

    @Test
    @DisplayName("Should throw when deleting non-existent product")
    void shouldThrowWhenDeletingNonExistent() {
        when(productRepository.findById(5L)).thenReturn(Optional.empty());

        assertThatThrownBy(() -> productService.deleteProduct(5L))
                .isInstanceOf(ProductNotFoundException.class);

        verify(productRepository, never()).deleteById(any());
    }

    // ═════════════════════════════════════════════════════════════════════════
    // DISCOUNT — Polymorphism test
    // ═════════════════════════════════════════════════════════════════════════

    @Test
    @DisplayName("Should return discounted price via strategy (Polymorphism)")
    void shouldReturnDiscountedPrice() {
        Product entity = sampleProduct(); // price = 999.99

        when(productRepository.findById(1L)).thenReturn(Optional.of(entity));
        when(discountStrategy.apply(entity)).thenReturn(new BigDecimal("899.99"));

        BigDecimal result = productService.getDiscountedPrice(1L);

        assertThat(result).isEqualByComparingTo("899.99");
        // GRASP: Polymorphism — strategy was called through the interface
        verify(discountStrategy).apply(entity);
    }

    // ═════════════════════════════════════════════════════════════════════════
    // SELL — Information Expert test
    // ═════════════════════════════════════════════════════════════════════════

    @Test
    @DisplayName("Should deduct stock when selling")
    void shouldDeductStockWhenSelling() {
        Product         entity   = sampleProduct(); // stock = 10
        ProductResponse response = sampleResponse(entity);
        response.setStockQuantity(7);

        when(productRepository.findById(1L)).thenReturn(Optional.of(entity));
        when(productRepository.save(entity)).thenReturn(entity);
        when(productMapper.toResponse(entity)).thenReturn(response);

        ProductResponse result = productService.sellProduct(1L, 3);

        // GRASP: Information Expert — entity managed its own stock
        assertThat(entity.getStockQuantity()).isEqualTo(7);
        verify(productRepository).save(entity);
    }

    @Test
    @DisplayName("Should throw when selling with zero or negative quantity")
    void shouldThrowForInvalidSellQuantity() {
        assertThatThrownBy(() -> productService.sellProduct(1L, 0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("greater than zero");

        assertThatThrownBy(() -> productService.sellProduct(1L, -5))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("Should throw when selling more than available stock")
    void shouldThrowWhenInsufficientStock() {
        Product entity = sampleProduct(); // stock = 10
        when(productRepository.findById(1L)).thenReturn(Optional.of(entity));

        assertThatThrownBy(() -> productService.sellProduct(1L, 99))
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("Insufficient stock");
    }
}
