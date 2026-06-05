package com.learning.appl.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.learning.appl.dto.ProductRequest;
import com.learning.appl.dto.ProductResponse;
import com.learning.appl.exceptions.ProductNotFoundException;
import com.learning.appl.service.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * ProductControllerTest
 * Uses @WebMvcTest to test only the controller layer (no DB, no real service).
 * Verifies HTTP status codes, response bodies, and routing.
 */
@WebMvcTest(ProductController.class)
class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductService productService;

    @Autowired
    private ObjectMapper objectMapper;

    private ProductResponse sampleResponse() {
        return new ProductResponse(1L, "Laptop", "Electronics",
                999.99, 899.99, 10, "A laptop", true);
    }

    // ─── GET /api/products ────────────────────────────────────────────────────────

    @Test
    void getAllProducts_returns200WithList() throws Exception {
        when(productService.getAllProducts()).thenReturn(List.of(sampleResponse()));

        mockMvc.perform(get("/api/products"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("Laptop"))
                .andExpect(jsonPath("$[0].available").value(true));
    }

    @Test
    void getAllProducts_emptyList_returns200() throws Exception {
        when(productService.getAllProducts()).thenReturn(List.of());

        mockMvc.perform(get("/api/products"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isEmpty());
    }

    // ─── GET /api/products/{id} ───────────────────────────────────────────────────

    @Test
    void getProductById_found_returns200() throws Exception {
        when(productService.getProductById(1L)).thenReturn(sampleResponse());

        mockMvc.perform(get("/api/products/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.name").value("Laptop"));
    }

    @Test
    void getProductById_notFound_returns404() throws Exception {
        when(productService.getProductById(99L)).thenThrow(new ProductNotFoundException(99L));

        mockMvc.perform(get("/api/products/99"))
                .andExpect(status().isNotFound());
    }

    // ─── POST /api/products ───────────────────────────────────────────────────────

    @Test
    void createProduct_validRequest_returns201() throws Exception {
        ProductRequest request = new ProductRequest("Laptop", "Electronics", 999.99, 10, "A laptop");
        when(productService.createProduct(any())).thenReturn(sampleResponse());

        mockMvc.perform(post("/api/products")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.name").value("Laptop"));
    }

    // ─── PUT /api/products/{id} ───────────────────────────────────────────────────

    @Test
    void updateProduct_validRequest_returns200() throws Exception {
        ProductRequest request = new ProductRequest("Laptop Pro", "Electronics", 1299.99, 5, "Updated");
        ProductResponse updated = new ProductResponse(1L, "Laptop Pro", "Electronics",
                1299.99, 1169.99, 5, "Updated", true);
        when(productService.updateProduct(eq(1L), any())).thenReturn(updated);

        mockMvc.perform(put("/api/products/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Laptop Pro"));
    }

    // ─── DELETE /api/products/{id} ────────────────────────────────────────────────

    @Test
    void deleteProduct_existingId_returns204() throws Exception {
        doNothing().when(productService).deleteProduct(1L);

        mockMvc.perform(delete("/api/products/1"))
                .andExpect(status().isNoContent());
    }

    @Test
    void deleteProduct_notFound_returns404() throws Exception {
        doThrow(new ProductNotFoundException(99L)).when(productService).deleteProduct(99L);

        mockMvc.perform(delete("/api/products/99"))
                .andExpect(status().isNotFound());
    }
}
