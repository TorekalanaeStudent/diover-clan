package com.learning.appl.repository;

import com.learning.appl.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * ProductRepository — GRASP: Indirection
 * Acts as the middleman between service and database.
 * Neither the service nor the entity knows about the DB directly.
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByCategory(String category);
    List<Product> findByStockQuantityGreaterThan(int quantity);
}
