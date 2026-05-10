package com.ablis.app.service;

import com.ablis.app.entity.Product;
import com.ablis.app.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> listAllProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    public Product save(Product product) {
        return productRepository.save(product);
    }

    public Optional<Product> update(Long id, Product updatedProduct) {
        return productRepository.findById(id)
                .map(existing -> {
                    updatedProduct.setId(id);
                    return productRepository.save(updatedProduct);
                });
    }

    public void delete(Long id) {
        productRepository.deleteById(id);
    }
}