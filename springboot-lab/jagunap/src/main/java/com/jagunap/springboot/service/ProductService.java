package com.jagunap.springboot.service;

import com.jagunap.springboot.entity.Product;
import com.jagunap.springboot.exception.ResourceNotFoundException;
import com.jagunap.springboot.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

// Separation of concerns: handles only business logic for Products
// Abstraction: hides implementation details from controller
@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Product not found with ID: " + id));
    }

    public Product createProduct(Product product) {
        if (product.getName() == null || product.getName().isBlank()) {
            throw new IllegalArgumentException("Product name must not be empty");
        }
        if (product.getPrice() == null || product.getPrice() <= 0) {
            throw new IllegalArgumentException("Product price must be greater than 0");
        }
        return productRepository.save(product);
    }

    public Product updateProduct(Long id, Product updatedProduct) {
        Product existing = getProductById(id);
        if (updatedProduct.getName() != null) existing.setName(updatedProduct.getName());
        if (updatedProduct.getDescription() != null) existing.setDescription(updatedProduct.getDescription());
        if (updatedProduct.getPrice() != null) existing.setPrice(updatedProduct.getPrice());
        if (updatedProduct.getCategory() != null) existing.setCategory(updatedProduct.getCategory());
        if (updatedProduct.getStock() != null) existing.setStock(updatedProduct.getStock());
        return productRepository.save(existing);
    }

    public void deleteProduct(Long id) {
        if (!productRepository.existsById(id)) {
            throw new ResourceNotFoundException("Product not found with ID: " + id);
        }
        productRepository.deleteById(id);
    }
}