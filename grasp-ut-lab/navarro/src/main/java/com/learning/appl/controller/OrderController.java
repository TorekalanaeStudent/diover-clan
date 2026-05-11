package com.learning.appl.controller;

import com.learning.appl.dto.OrderRequest;
import com.learning.appl.dto.OrderResponse;
import com.learning.appl.entity.OrderStatus;
import com.learning.appl.service.OrderService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * GRASP: Controller
 * This delegates all business logic
 * to OrderService and never accesses the repository directly.
 *
 * GRASP: Low Coupling
 * Controller depends only on OrderService
 *
 * GRASP: High Cohesion
 * This class only handles HTTP routing and response wrapping
 */

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    // GRASP: Low Coupling — depends on service, not on repository or entities
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    // ── POST /api/orders ──────────────────────────────────────────────────────
    @PostMapping
    public ResponseEntity<OrderResponse> createOrder(@Valid @RequestBody OrderRequest request) {
        // GRASP: Controller — delegates to service, no business logic here
        OrderResponse response = orderService.createOrder(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    // ── GET /api/orders ───────────────────────────────────────────────────────
    @GetMapping
    public ResponseEntity<List<OrderResponse>> getAllOrders() {
        return ResponseEntity.ok(orderService.getAllOrders());
    }

    // ── GET /api/orders/{id} ──────────────────────────────────────────────────
    @GetMapping("/{id}")
    public ResponseEntity<OrderResponse> getOrderById(@PathVariable Long id) {
        return ResponseEntity.ok(orderService.getOrderById(id));
    }

    // ── GET /api/orders/customer/{name} ───────────────────────────────────────
    @GetMapping("/customer/{name}")
    public ResponseEntity<List<OrderResponse>> getByCustomer(@PathVariable String name) {
        return ResponseEntity.ok(orderService.getOrdersByCustomer(name));
    }

    // ── PATCH /api/orders/{id}/status ─────────────────────────────────────────
    @PatchMapping("/{id}/status")
    public ResponseEntity<OrderResponse> updateStatus(
            @PathVariable Long id,
            @RequestParam OrderStatus status) {
        return ResponseEntity.ok(orderService.updateStatus(id, status));
    }

    // ── DELETE /api/orders/{id} ───────────────────────────────────────────────
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> cancelOrder(@PathVariable Long id) {
        orderService.cancelOrder(id);
        return ResponseEntity.noContent().build();
    }
}