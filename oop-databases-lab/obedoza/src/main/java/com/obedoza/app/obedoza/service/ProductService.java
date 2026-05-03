package com.obedoza.app.obedoza.service;

import com.obedoza.app.obedoza.entity.Product;
import com.obedoza.app.obedoza.exception.ResourceNotFoundException;
import com.obedoza.app.obedoza.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with id: " + id));
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public Product updateProduct(Long id, Product updatedProduct) {
        Product existing = getProductById(id);
        if (updatedProduct.getName() != null) existing.setName(updatedProduct.getName());
        if (updatedProduct.getDescription() != null) existing.setDescription(updatedProduct.getDescription());
        if (updatedProduct.getPrice() != null) existing.setPrice(updatedProduct.getPrice());
        return productRepository.save(existing);
    }

    public void deleteProduct(Long id) {
        getProductById(id);
        productRepository.deleteById(id);
    }
}

