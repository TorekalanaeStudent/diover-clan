package com.nono.app.service;

import com.nono.app.entity.Product;
import com.nono.app.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import java.util.List;

/**
* Author Mary Angeline B. Nono
* 
* 1.What changed from previous lab?
* -I moved from simple file handling or basic code to working with real databases. I learned how to connect our Spring Boot application to store and retrieve data properly, instead of just using variables or temporary memory.
* 
* 2. Why database is better?
* - Data stays forever: Data is saved permanently even if I close the program.
* - Organized: Information is stored in neat tables with rows and columns, making it easy to find.
* - Safe & Secure: I can control who accesses the data and prevent mistakes.
* - Handles large amounts: It can store thousands or millions of records easily without slowing down.
*
* 3.How JPA helped?
*  -JPA (Java Persistence API) made our work much easier. Instead of writing long and complicated SQL queries manually, I just used Java code and annotations. It automatically created tables, inserted data, and handled connections for us. It saved a lot of time and reduced errors.
*
* 4.What changed when switching DB?
* -When I switched from H2 to PostgreSQL:
* -I had to change the URL, username, and password in  application.properties .
*- I added the correct PostgreSQL Driver dependency.
*- The way I write code stayed almost the same because JPA works with many databases. Only the configuration part changed.
**/

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
