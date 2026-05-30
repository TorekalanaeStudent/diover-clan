package com.ovejera.fullstackApp.Repository;

import com.ovejera.fullstackApp.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
