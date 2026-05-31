package com.obedoza.app.repository;


import com.obedoza.app.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

// GRASP: Indirection
// Acts as a middle layer between the service and the database.
// Service never talks to DB directly — it goes through this interface.
public interface OrderRepository extends JpaRepository<Order, Long> {
    // Spring Data JPA automatically generates the SQL
}
