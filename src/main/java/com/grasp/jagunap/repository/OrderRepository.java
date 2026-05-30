package com.grasp.jagunap.repository;

import com.grasp.jagunap.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

// GRASP: Indirection — Repository sits between the Service and the database.
//        The Service never makes direct DB calls; it always goes through here.
public interface OrderRepository extends JpaRepository<Order, Long> {
}