package com.nono.app.service;

import com.nono.app.entity.Product;
import com.nono.app.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private Object getIsAvailable;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProduct(Long id) {
        return productRepository.findById(id).orElseThrow(() -> new ResourceAccessException("Product not found wit id: " +id));
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public Product updateProduct(Long id, Product product) {
        Product existing = getProduct(id);

        existing.setName(product.getName());
        existing.setPrice(product.getPrice());
        existing.setCategory(product.getCategory());
        existing.setDescription(product.getDescription());
        existing.setIsAvailable(product.getIsAvailable());

        return productRepository.save(existing);
    }
    public void deleteProduct(Long id){
        getProductById(id);
        productRepository.deleteById(id);

    }

    private void getProductById(Long id) {
    }
}
