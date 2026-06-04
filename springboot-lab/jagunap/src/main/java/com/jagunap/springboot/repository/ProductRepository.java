package com.jagunap.springboot.repository;

import com.jagunap.springboot.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

// Abstraction: hides database implementation details
// Separation of concerns: only handles data access
public interface ProductRepository extends JpaRepository<Product, Long> {
}