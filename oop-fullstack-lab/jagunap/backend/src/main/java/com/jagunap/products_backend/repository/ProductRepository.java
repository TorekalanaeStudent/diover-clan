package com.jagunap.products_backend.repository;

import com.jagunap.products_backend.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    // JpaRepository gives us all CRUD for free (Polymorphism ✅)
}