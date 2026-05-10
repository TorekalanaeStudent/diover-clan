package com.caneda.app.repository;

import com.caneda.app.entities.Product_Caneda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProductRepository_Caneda extends JpaRepository<Product_Caneda, Long> {
    Product_Caneda findByProductName(String productName);
    Product_Caneda findByCategory(String category);
    Product_Caneda findByDescription(String description);
    List<Product_Caneda> findAllByPrice(Double price);
    List<Product_Caneda> findAllByQuantity(int quantity);
}
