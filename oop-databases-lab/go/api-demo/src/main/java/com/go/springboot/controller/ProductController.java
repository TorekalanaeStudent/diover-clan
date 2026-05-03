package com.go.springboot.controller;

/*  Reflection
 *
 *  @author Go, Sean Ethan
 *  @sethplaysbadly
 *
 * 1. What changed from previous lab?
 * A: This lab replaced the prior lab with an actual database persistence with additional User/Product entities,
 *    repositories, services, and CRUD endpoints.
 *
 * 2. Why database is better?
 * A: You have the ability to easily store, update, and delete records without tampering with the source code,
 *    multiple users can read/write data at the same time; like an actual app with a server backend.
 *
 * 3. How JPA helped?
 * A: Switching databases required zero changes to your Java code and aides complex SQL
 *    into simple Java interfaces,
 *
 * 4. What changed when switching DB?
 * A: Only application.properties changed. To change it just comment out the H2 line
 *    and uncomment PostgreSQL lines.
 *
 */

import com.go.springboot.entity.Product;
import com.go.springboot.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public List<Product> getAll() {
        return productService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getById(@PathVariable Long id) {
        return ResponseEntity.ok(productService.getById(id));
    }

    @PostMapping
    public ResponseEntity<Product> create(@Valid @RequestBody Product product) {
        return ResponseEntity.ok(productService.create(product));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> update(@PathVariable Long id, @RequestBody Product product) {
        return ResponseEntity.ok(productService.update(id, product));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        productService.delete(id);
        return ResponseEntity.noContent().build();
    }
}