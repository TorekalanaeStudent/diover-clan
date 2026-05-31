package com.ovejera.app.grasp.service;

import com.ovejera.app.grasp.entity.Order;
import com.ovejera.app.grasp.exception.OrderNotFoundException;
import com.ovejera.app.grasp.repository.OrderRepository;
import org.springframework.stereotype.Service;

// GRASP: Pure Fabrication
@Service
public class OrderService {

    private final OrderRepository repository;

    private final PaymentStrategy paymentStrategy;

    public OrderService(
            OrderRepository repository,
            PaymentStrategy paymentStrategy) {

        this.repository = repository;
        this.paymentStrategy = paymentStrategy;
    }

    public Order createOrder(Order order) {

        double total = order.calculateTotal();

        paymentStrategy.processPayment(total);

        return repository.save(order);
    }

    public Order getOrder(Long id) {

        return repository.findById(id)
                .orElseThrow(
                        () -> new OrderNotFoundException(
                                "Order not found"));
    }
}