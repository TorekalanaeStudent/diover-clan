package com.app.repository;

import com.app.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * GRASP: Indirection
 * ──────────────────
 * Sits between the service layer and the database.
 * ProductService never writes SQL; it speaks through this interface.
 * Swapping PostgreSQL for another DB only requires changing configuration,
 * not the service code.
 *
 * GRASP: Low Coupling
 * ───────────────────
 * Service depends on this interface (Spring injects the implementation),
 * not on a concrete DAO class. Testable by mocking.
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByCategory(String category);

    List<Product> findByStockQuantityGreaterThan(int quantity);

    boolean existsByName(String name);
}
