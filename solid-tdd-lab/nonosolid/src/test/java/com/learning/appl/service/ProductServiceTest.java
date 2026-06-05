package com.learning.appl.service;

import com.learning.appl.dto.ProductRequest;
import com.learning.appl.dto.ProductResponse;
import com.learning.appl.entity.Product;
import com.learning.appl.entity.ProductSnapshot;
import com.learning.appl.exceptions.ProductNotFoundException;
import com.learning.appl.mapper.ProductMapper;
import com.learning.appl.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

/**
 * ProductServiceTest
 * Demonstrates: Mockito mocking, DIP (injected interfaces tested in isolation),
 * edge-case testing, and verifying notify() is called.
 */
@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    @Mock private ProductRepository productRepository;
    @Mock private ProductMapper productMapper;
    @Mock private DiscountStrategy discountStrategy;
    @Mock private Notifier notifier;
    @Mock private ProductValidator productValidator;

    @InjectMocks
    private ProductService productService;

    private Product sampleProduct;
    private ProductRequest sampleRequest;
    private ProductResponse sampleResponse;

    @BeforeEach
    void setUp() {
        sampleProduct = new Product("Laptop", "Electronics", 999.99, 10, "A laptop");
        sampleProduct.setId(1L);

        sampleRequest = new ProductRequest("Laptop", "Electronics", 999.99, 10, "A laptop");

        sampleResponse = new ProductResponse(1L, "Laptop", "Electronics",
                999.99, 899.99, 10, "A laptop", true);
    }

    // ─── getAllProducts ───────────────────────────────────────────────────────────

    @Test
    void getAllProducts_returnsMappedList() {
        when(productRepository.findAll()).thenReturn(List.of(sampleProduct));
        when(productMapper.toResponse(sampleProduct, discountStrategy)).thenReturn(sampleResponse);

        List<ProductResponse> result = productService.getAllProducts();

        assertThat(result).hasSize(1);
        assertThat(result.get(0).getName()).isEqualTo("Laptop");
    }

    @Test
    void getAllProducts_emptyRepository_returnsEmptyList() {
        when(productRepository.findAll()).thenReturn(List.of());

        List<ProductResponse> result = productService.getAllProducts();

        assertThat(result).isEmpty();
    }

    // ─── getProductById ───────────────────────────────────────────────────────────

    @Test
    void getProductById_existingId_returnsResponse() {
        when(productRepository.findById(1L)).thenReturn(Optional.of(sampleProduct));
        when(productMapper.toResponse(sampleProduct, discountStrategy)).thenReturn(sampleResponse);

        ProductResponse result = productService.getProductById(1L);

        assertThat(result.getId()).isEqualTo(1L);
        assertThat(result.getName()).isEqualTo("Laptop");
    }

    @Test
    void getProductById_notFound_throwsException() {
        when(productRepository.findById(99L)).thenReturn(Optional.empty());

        assertThatThrownBy(() -> productService.getProductById(99L))
                .isInstanceOf(ProductNotFoundException.class)
                .hasMessageContaining("99");
    }

    // ─── createProduct ────────────────────────────────────────────────────────────

    @Test
    void createProduct_validRequest_savesAndNotifies() {
        when(productMapper.toEntity(sampleRequest)).thenReturn(sampleProduct);
        when(productRepository.save(sampleProduct)).thenReturn(sampleProduct);
        when(productMapper.toResponse(sampleProduct, discountStrategy)).thenReturn(sampleResponse);

        ProductResponse result = productService.createProduct(sampleRequest);

        assertThat(result.getName()).isEqualTo("Laptop");
        verify(productValidator).validate(sampleRequest);
        verify(notifier).notify(contains("Laptop"));
    }

    @Test
    void createProduct_validationFails_throwsException() {
        doThrow(new IllegalArgumentException("Name required"))
                .when(productValidator).validate(any());

        assertThatThrownBy(() -> productService.createProduct(sampleRequest))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Name required");

        verify(productRepository, never()).save(any());
    }

    // ─── updateProduct ────────────────────────────────────────────────────────────

    @Test
    void updateProduct_existingId_updatesAndNotifies() {
        when(productRepository.findById(1L)).thenReturn(Optional.of(sampleProduct));
        when(productRepository.save(sampleProduct)).thenReturn(sampleProduct);
        when(productMapper.toResponse(sampleProduct, discountStrategy)).thenReturn(sampleResponse);

        ProductResponse result = productService.updateProduct(1L, sampleRequest);

        assertThat(result).isNotNull();
        verify(notifier).notify(anyString());
    }

    @Test
    void updateProduct_notFound_throwsException() {
        when(productRepository.findById(99L)).thenReturn(Optional.empty());

        assertThatThrownBy(() -> productService.updateProduct(99L, sampleRequest))
                .isInstanceOf(ProductNotFoundException.class);
    }

    // ─── deleteProduct ────────────────────────────────────────────────────────────

    @Test
    void deleteProduct_existingId_deletesAndNotifies() {
        when(productRepository.findById(1L)).thenReturn(Optional.of(sampleProduct));

        productService.deleteProduct(1L);

        verify(productRepository).delete(sampleProduct);
        verify(notifier).notify(contains("Laptop"));
    }

    @Test
    void deleteProduct_notFound_throwsException() {
        when(productRepository.findById(99L)).thenReturn(Optional.empty());

        assertThatThrownBy(() -> productService.deleteProduct(99L))
                .isInstanceOf(ProductNotFoundException.class);

        verify(productRepository, never()).delete(any());
    }

    // ─── snapshotProduct ──────────────────────────────────────────────────────────

    @Test
    void snapshotProduct_returnsImmutableSnapshot() {
        when(productRepository.findById(1L)).thenReturn(Optional.of(sampleProduct));

        ProductSnapshot snapshot = productService.snapshotProduct(1L);

        assertThat(snapshot.name()).isEqualTo("Laptop");
        assertThat(snapshot.price()).isEqualTo(999.99);
    }

    // ─── getAvailableProducts ─────────────────────────────────────────────────────

    @Test
    void getAvailableProducts_returnsOnlyInStock() {
        when(productRepository.findByStockQuantityGreaterThan(0)).thenReturn(List.of(sampleProduct));
        when(productMapper.toResponse(sampleProduct, discountStrategy)).thenReturn(sampleResponse);

        List<ProductResponse> result = productService.getAvailableProducts();

        assertThat(result).hasSize(1);
        assertThat(result.get(0).isAvailable()).isTrue();
    }
}
