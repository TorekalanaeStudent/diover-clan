package com.go.springboot.service;
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
import com.go.springboot.exception.ResourceNotFoundException;
import com.go.springboot.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAll() {
        return productRepository.findAll();
    }

    public Product getById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with id: " + id));
    }

    public Product create(Product product) {
        return productRepository.save(product);
    }

    public Product update(Long id, Product updated) {
        Product product = getById(id);
        if (updated.getName() != null) product.setName(updated.getName());
        if (updated.getDescription() != null) product.setDescription(updated.getDescription());
        if (updated.getPrice() != null) product.setPrice(updated.getPrice());
        if (updated.getCategory() != null) product.setCategory(updated.getCategory());
        if (updated.getStock() != null) product.setStock(updated.getStock());
        return productRepository.save(product);
    }

    public void delete(Long id) {
        productRepository.delete(getById(id));
    }
}