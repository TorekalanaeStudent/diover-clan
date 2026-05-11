package com.learning.appl.repository;


import com.learning.appl.entity.Order;
import com.learning.appl.entity.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * GRASP: Indirection
 * OrderRepository acts as a mediating layer between the Service and the
 * database.
 *
 * GRASP: Low Coupling
 * Service only depends on this interface, not on any JPA implementation detail.
 */

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findByCustomerName(String customerName);

    List<Order> findByStatus(OrderStatus status);
}