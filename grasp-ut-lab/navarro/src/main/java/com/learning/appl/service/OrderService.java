package com.learning.appl.service;

import com.learning.appl.dto.OrderRequest;
import com.learning.appl.dto.OrderResponse;
import com.learning.appl.entity.Order;
import com.learning.appl.entity.OrderStatus;
import com.learning.appl.exception.OrderNotFoundException;
import com.learning.appl.payment.PaymentProcessor;
import com.learning.appl.payment.PaymentProcessorFactory;
import com.learning.appl.repository.OrderRepository;
import com.learning.appl.util.OrderValidator;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

/**
 * GRASP: Pure Fabrication
 * OrderService doesn't correspond to a real-world thing — it exists to hold
 * business logic that doesn't belong in the entity or the controller.
 *
 * GRASP: High Cohesion
 * Handles only order-lifecycle business logic.  No HTTP, no SQL, no UI.
 *
 * GRASP: Low Coupling
 * Depends on interfaces (OrderRepository, PaymentProcessorFactory, OrderValidator),
 * not on concrete classes.  Spring injects the real implementations at runtime.
 *
 * GRASP: Indirection
 * Sits between Controller and Repository, shielding each side from the other.
 */
@Service
@Transactional
public class OrderService {

    // GRASP: Low Coupling — depends on interface, not JPA implementation
    private final OrderRepository        orderRepository;

    // GRASP: Indirection — factory shields service from concrete processor types
    private final PaymentProcessorFactory processorFactory;

    // GRASP: Pure Fabrication — validator is injected, not instantiated inline
    private final OrderValidator          validator;

    public OrderService(OrderRepository orderRepository,
                        PaymentProcessorFactory processorFactory,
                        OrderValidator validator) {
        this.orderRepository  = orderRepository;
        this.processorFactory = processorFactory;
        this.validator        = validator;
    }

    // ── Create ────────────────────────────────────────────────────────────────

    public OrderResponse createOrder(OrderRequest request) {
        // GRASP: Pure Fabrication — delegate validation to the specialist
        validator.validate(request);

        // GRASP: Creator — Order creates its own OrderItems
        Order order = new Order(request.getCustomerName());
        request.getItems().forEach(i ->
                order.addItem(i.getProductName(), i.getQuantity(), i.getUnitPrice()));

        // GRASP: Polymorphism + Protected Variations — service doesn't know
        // which processor it gets; it just calls the interface method
        PaymentProcessor processor = processorFactory.getProcessor(request.getPaymentMethod());
        processor.process(order.calculateTotal());

        order.setStatus(OrderStatus.CONFIRMED);

        // GRASP: Indirection — repository hides all persistence details
        Order saved = orderRepository.save(order);
        return OrderResponse.from(saved);
    }

    // ── Read ──────────────────────────────────────────────────────────────────

    @Transactional(readOnly = true)
    public OrderResponse getOrderById(Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new OrderNotFoundException(id));
        return OrderResponse.from(order);
    }

    @Transactional(readOnly = true)
    public List<OrderResponse> getAllOrders() {
        return orderRepository.findAll().stream()
                .map(OrderResponse::from)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<OrderResponse> getOrdersByCustomer(String customerName) {
        return orderRepository.findByCustomerName(customerName).stream()
                .map(OrderResponse::from)
                .collect(Collectors.toList());
    }

    // ── Update ────────────────────────────────────────────────────────────────

    public OrderResponse updateStatus(Long id, OrderStatus newStatus) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new OrderNotFoundException(id));
        order.setStatus(newStatus);
        return OrderResponse.from(orderRepository.save(order));
    }

    // ── Delete ────────────────────────────────────────────────────────────────

    public void cancelOrder(Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new OrderNotFoundException(id));
        order.setStatus(OrderStatus.CANCELLED);
        orderRepository.save(order);
    }
}