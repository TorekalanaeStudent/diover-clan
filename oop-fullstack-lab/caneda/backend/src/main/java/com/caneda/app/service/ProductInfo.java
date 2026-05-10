package com.caneda.app.service;

import com.caneda.app.entities.Product_Caneda;
import com.caneda.app.repository.ProductRepository_Caneda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductInfo {

    @Autowired
    private ProductRepository_Caneda productRepository;

    public Product_Caneda getProductByName(String productName) {
        return productRepository.findByProductName(productName);
    }

    public Product_Caneda getProductByCategory(String category) {
        return productRepository.findByCategory(category);
    }

    public List<Product_Caneda> getProductsByPrice(Double price) {
        return productRepository.findAllByPrice(price);
    }

    public void showProduct(String productName) {
        Product_Caneda product = getProductByName(productName);
        if(product != null) {
            System.out.println("Product ID: " + product.getProductId());
            System.out.println("Product Name: " + product.getProductName());
            System.out.println("Description: " + product.getDescription());
            System.out.println("Price: $" + product.getPrice());
            System.out.println("Category: " + product.getCategory());
            System.out.println("Quantity: " + product.getQuantity());
        } else {
            System.out.println("Product not found");
        }
    }
}
