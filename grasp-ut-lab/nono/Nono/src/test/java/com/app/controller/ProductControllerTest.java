package com.app.controller;

import com.app.dto.ProductRequest;
import com.app.dto.ProductResponse;
import com.app.exception.GlobalExceptionHandler;
import com.app.exception.ProductNotFoundException;
import com.app.service.ProductService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.List;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Controller layer tests — no real service or DB.
 *
 * GRASP validated:
 *  - Controller : only HTTP wiring is tested here; business logic is mocked
 *  - Low Coupling: controller talks to mocked service interface
 */
@WebMvcTest(ProductController.class)
@Import(GlobalExceptionHandler.class)
class ProductControllerTest {

    @Autowired private MockMvc       mockMvc;
    @Autowired private ObjectMapper  objectMapper;
    @MockBean  private ProductService productService;

    // ── Helpers ───────────────────────────────────────────────────────────────

    private ProductResponse sampleResponse() {
        ProductResponse r = new ProductResponse();
        r.setId(1L);
        r.setName("Laptop");
        r.setCategory("Electronics");
        r.setPrice(new BigDecimal("999.99"));
        r.setStockQuantity(10);
        r.setAvailable(true);
        return r;
    }

    private ProductRequest sampleRequest() {
        ProductRequest r = new ProductRequest();
        r.setName("Laptop");
        r.setCategory("Electronics");
        r.setPrice(new BigDecimal("999.99"));
        r.setStockQuantity(10);
        return r;
    }

    // ═════════════════════════════════════════════════════════════════════════
    // POST /api/products
    // ═════════════════════════════════════════════════════════════════════════

    @Test
    @DisplayName("POST /api/products → 201 Created")
    void shouldCreateProduct() throws Exception {
        when(productService.createProduct(any())).thenReturn(sampleResponse());

        mockMvc.perform(post("/api/products")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(sampleRequest())))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.name").value("Laptop"))
                .andExpect(jsonPath("$.id").value(1));
    }

    @Test
    @DisplayName("POST /api/products with missing name → 400 Bad Request")
    void shouldRejectInvalidRequest() throws Exception {
        ProductRequest bad = sampleRequest();
        bad.setName(""); // blank name — fails @NotBlank

        mockMvc.perform(post("/api/products")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(bad)))
                .andExpect(status().isBadRequest());
    }

    // ═════════════════════════════════════════════════════════════════════════
    // GET /api/products/{id}
    // ═════════════════════════════════════════════════════════════════════════

    @Test
    @DisplayName("GET /api/products/1 → 200 OK")
    void shouldGetProductById() throws Exception {
        when(productService.getProductById(1L)).thenReturn(sampleResponse());

        mockMvc.perform(get("/api/products/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.name").value("Laptop"));
    }

    @Test
    @DisplayName("GET /api/products/99 → 404 Not Found")
    void shouldReturn404ForUnknownId() throws Exception {
        when(productService.getProductById(99L))
                .thenThrow(new ProductNotFoundException(99L));

        mockMvc.perform(get("/api/products/99"))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message").value("Product not found with id: 99"));
    }

    // ═════════════════════════════════════════════════════════════════════════
    // GET /api/products
    // ═════════════════════════════════════════════════════════════════════════

    @Test
    @DisplayName("GET /api/products → 200 with list")
    void shouldGetAllProducts() throws Exception {
        when(productService.getAllProducts()).thenReturn(List.of(sampleResponse()));

        mockMvc.perform(get("/api/products"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(1));
    }

    // ═════════════════════════════════════════════════════════════════════════
    // PUT /api/products/{id}
    // ═════════════════════════════════════════════════════════════════════════

    @Test
    @DisplayName("PUT /api/products/1 → 200 Updated")
    void shouldUpdateProduct() throws Exception {
        ProductResponse updated = sampleResponse();
        updated.setName("Gaming Laptop");
        when(productService.updateProduct(eq(1L), any())).thenReturn(updated);

        mockMvc.perform(put("/api/products/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(sampleRequest())))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Gaming Laptop"));
    }

    // ═════════════════════════════════════════════════════════════════════════
    // DELETE /api/products/{id}
    // ═════════════════════════════════════════════════════════════════════════

    @Test
    @DisplayName("DELETE /api/products/1 → 204 No Content")
    void shouldDeleteProduct() throws Exception {
        doNothing().when(productService).deleteProduct(1L);

        mockMvc.perform(delete("/api/products/1"))
                .andExpect(status().isNoContent());

        verify(productService).deleteProduct(1L);
    }

    // ═════════════════════════════════════════════════════════════════════════
    // GET /api/products/{id}/discounted-price
    // ═════════════════════════════════════════════════════════════════════════

    @Test
    @DisplayName("GET /api/products/1/discounted-price → 200 with price")
    void shouldGetDiscountedPrice() throws Exception {
        when(productService.getDiscountedPrice(1L)).thenReturn(new BigDecimal("899.99"));

        mockMvc.perform(get("/api/products/1/discounted-price"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.discountedPrice").value(899.99));
    }
}
