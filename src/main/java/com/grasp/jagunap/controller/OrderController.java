package com.grasp.jagunap.controller;

import com.grasp.jagunap.dto.OrderDTO;
import com.grasp.jagunap.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

// GRASP: Controller — handles HTTP requests only, delegates to OrderService
//        Contains ZERO business logic
@RestController
@RequestMapping("/api/orders")
public class OrderController {

    // GRASP: Low Coupling — depends on OrderService, not implementations
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<OrderDTO> createOrder(@RequestBody OrderDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(orderService.createOrder(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderDTO> getOrder(@PathVariable Long id) {
        return ResponseEntity.ok(orderService.getOrderById(id));
    }

    @GetMapping
    public ResponseEntity<List<OrderDTO>> getAllOrders() {
        return ResponseEntity.ok(orderService.getAllOrders());
    }

    @PostMapping("/{id}/notify")
    public ResponseEntity<Map<String, String>> sendNotification(
            @PathVariable Long id,
            @RequestParam String type) {
        orderService.sendNotification(id, type);
        return ResponseEntity.ok(Map.of("message", "Notification sent successfully"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long id) {
        orderService.deleteOrder(id);
        return ResponseEntity.noContent().build();
    }
}