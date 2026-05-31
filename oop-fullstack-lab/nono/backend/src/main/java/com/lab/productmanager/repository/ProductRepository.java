package com.lab.productmanager.repository;

import com.lab.productmanager.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * OOP - Abstraction & Polymorphism:
 * JpaRepository provides CRUD operations through polymorphism.
 * The actual SQL is abstracted — we just call methods.
 * OOP - Separation of Concerns:
 * This layer is ONLY responsible for database access.
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    // Custom query: find by category
    List<Product> findByCategory(String category);

    // Custom query: find by name containing (case-insensitive)
    List<Product> findByNameContainingIgnoreCase(String name);
}
