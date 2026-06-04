package com.grasp.jagunap.repository;

import com.grasp.jagunap.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

// GRASP: Indirection - acts as a layer between DB and service
// Service never talks to the DB directly; it goes through this interface
// GRASP: Low Coupling - service depends on this interface, not a DB implementation
@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByCustomerName(String customerName);
    List<Order> findByStatus(String status);
}
