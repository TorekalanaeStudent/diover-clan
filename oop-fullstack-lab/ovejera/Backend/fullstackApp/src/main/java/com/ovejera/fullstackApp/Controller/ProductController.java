package com.ovejera.fullstackApp.Controller;


import com.ovejera.fullstackApp.Entity.Product;
import com.ovejera.fullstackApp.Service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/")
    public ResponseEntity<List<Product>> getProduct () {
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById (Long id) {
        return ResponseEntity.ok(productService.getProductById(id));
    }

    @PostMapping("/create")
    public ResponseEntity<Product> createProduct (@RequestParam String name, @RequestParam String description, @RequestParam Double price, @RequestParam Integer quantity) {
        Product p = new Product();
        p.setName(name);
        p.setDescription(description);
        p.setPrice(price);
        p.setQuantity(quantity);
        return ResponseEntity.ok(productService.createProducts(p));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Product> updateProduct (@PathVariable Long id, @Valid @RequestBody Product product) {
        return ResponseEntity.ok(productService.updateProduct(id, product));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteProduct (@PathVariable Long id) {
         productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }
}
