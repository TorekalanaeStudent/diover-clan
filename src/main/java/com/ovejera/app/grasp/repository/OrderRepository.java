package com.ovejera.app.grasp.repository;

import com.ovejera.app.grasp.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// GRASP: Indirection
@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

}