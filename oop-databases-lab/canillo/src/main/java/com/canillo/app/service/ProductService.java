package com.canillo.app.service;

import com.canillo.app.entity.Product;
import com.canillo.app.exception.ResourceNotFoundException;
import com.canillo.app.repository.ProductRepository;
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

    public Product getProduct(Long id) {
        return productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product not found wit id: " + id));
    }

    public Product createProduct(Product Product) {
        return productRepository.save(Product);
    }

    public Product updateProduct(Long id, Product Product) {
        Product existing = getProduct(id);

        existing.setName(Product.getName());
        existing.setPrice(Product.getPrice());
        existing.setCategory(Product.getCategory());
        existing.setDescription(Product.getDescription());
        existing.setIsAvailable(Product.getIsAvailable());

        return productRepository.save(existing);
    }

    public void deleteProduct(Long id) {
        getProduct(id);
        productRepository.deleteById(id);
    }
}
