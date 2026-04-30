package com.caneda.app.service;

import java.util.List;
import com.caneda.app.entities.Product_Caneda;
import com.caneda.app.repository.ProductRepository_Caneda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService_Caneda {

    @Autowired
    private ProductRepository_Caneda productRepository;

    public Product_Caneda createProduct(String productName, String description, Double price, int quantity, String category) {
        Product_Caneda newProduct = new Product_Caneda(productName, description, price, quantity, category);
        return productRepository.save(newProduct);
    }
    public List<Product_Caneda> getAllProducts() {
        return productRepository.findAll();
    }

    public Product_Caneda getProductById(long id) {
        return productRepository.findById(id).orElse(null);
    }

    public Product_Caneda updateProduct(long id, Product_Caneda updatedProduct) {
        Product_Caneda product = getProductById(id);
        if (product != null) {
            product.setProductName(updatedProduct.getProductName());
            product.setDescription(updatedProduct.getDescription());
            product.setPrice(updatedProduct.getPrice());
            product.setQuantity(updatedProduct.getQuantity());
            product.setCategory(updatedProduct.getCategory());
            return productRepository.save(product);
        }
        return null;
    }

    public void deleteProduct(long id) {
        productRepository.deleteById(id);
    }

}
