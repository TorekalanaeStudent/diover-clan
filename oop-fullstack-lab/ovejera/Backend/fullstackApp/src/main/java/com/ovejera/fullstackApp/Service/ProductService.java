package com.ovejera.fullstackApp.Service;

import com.ovejera.fullstackApp.Entity.Product;
import com.ovejera.fullstackApp.Exception.ResourceNotFoundException;
import com.ovejera.fullstackApp.Repository.ProductRepository;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
private final ProductRepository productRepository;

public ProductService (ProductRepository productRepository) {
    this.productRepository = productRepository;
}


    public List<Product> getAllProducts () {
    return productRepository.findAll();
}

    public Product getProductById (Long id) {
    return productRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Product not found with id: " + id));
    }

    public Product createProducts (Product product) {
        return productRepository.save(product);
    }

    public Product updateProduct(Long id, Product newProduct) {
        Product ex = getProductById(id);
        Optional.ofNullable(newProduct.getName()).ifPresent(ex::setName);

        Optional.of(newProduct.getPrice())
                .filter(p -> p > 0)
                .ifPresent(ex::setPrice);

        Optional.ofNullable(newProduct.getDescription())
                .ifPresent(ex::setDescription);
        Optional.ofNullable(newProduct.getQuantity())
                .ifPresent(ex::setQuantity);
        return productRepository.save(ex);
    }

    public void deleteProduct (Long id) {
        if (!productRepository.existsById(id)) {
            throw new ResourceNotFoundException("Product not found with id: " + id);
        }

        productRepository.deleteById(id);
    }


}
