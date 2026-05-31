package com.obedoza.app.service;

import com.obedoza.app.dto.*;
import com.obedoza.app.entity.*;
import com.obedoza.app.exception.OrderNotFoundException;
import com.obedoza.app.payment.PaymentProcessor;
import com.obedoza.app.repository.OrderRepository;
import com.obedoza.app.util.OrderValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

// GRASP: Pure Fabrication — doesn't map to a real-world thing; exists to hold business logic
// GRASP: High Cohesion — only handles order business logic, nothing else
@Service
@RequiredArgsConstructor
public class OrderServiceImplimentation implements OrderService {

    // SOLID: DIP - Depends on repository interface, not a concrete DB class
    private final OrderRepository orderRepository;

    // SOLID: DIP - Depends on PaymentProcessor interface
    private final OrderValidator orderValidator;

    // GRASP: Polymorphism — map of payment processors injected by Spring
    private final Map<String, PaymentProcessor> paymentProcessors;

    @Override
    public OrderResponse createOrder (OrderRequest request) {
        // Validate first (Pure Fabrication doing its job)
        orderValidator.validate(request);

        // GRASP: Creator — service creates the Order and delegates item creation
        Order order = new Order();
        order.setCustomerName(request.getCustomerName());
        order.setStatus("PENDING");
        order.setCreatedAt(LocalDateTime.now());

        // GRASP: Creator — Order creates its own OrderItems via addItem()
        request.getItems().forEach(item ->
                order.addItem(item.getProductName(), item.getQuantity(), item.getUnitPrice())
        );

        Order saved = orderRepository.save(order);
        return toResponse(saved);
    }

    @Override
    public OrderResponse getOrder(Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new OrderNotFoundException(id));
        return toResponse(order);
    }

    @Override
    public List<OrderResponse> getAllOrders() {
        return orderRepository.findAll()
                .stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public OrderResponse confirmOrder(Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new OrderNotFoundException(id));

        if (!"PENDING".equals(order.getStatus())) {
            throw new IllegalStateException("Only PENDING orders can be confirmed");
        }

        // GRASP: Polymorphism — using payment interface, not a specific impl
        PaymentProcessor processor = paymentProcessors.get("creditCard");
        // GRASP: Information Expert — order calculates its own total
        processor.process(order.calculateTotal());

        order.setStatus("CONFIRMED");
        return toResponse(orderRepository.save(order));
    }
    @Override
    public void cancelOrder(Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new OrderNotFoundException(id));

        if ("CONFIRMED".equals(order.getStatus())) {
            throw new IllegalStateException("Confirmed orders cannot be cancelled");
        }

        order.setStatus("CANCELLED");
        orderRepository.save(order);
    }

    // Private helper — keeps mapping logic out of the entity (High Cohesion)
    private OrderResponse toResponse(Order order) {
        return OrderResponse.builder()
                .id(order.getId())
                .customerName(order.getCustomerName())
                .status(order.getStatus())
                // GRASP: Information Expert — order knows how to calculate its total
                .total(order.calculateTotal())
                .createdAt(order.getCreatedAt())
                .build();
    }

}



