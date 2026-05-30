package com.grasp.jagunap.service;

import com.grasp.jagunap.dto.OrderDTO;
import com.grasp.jagunap.dto.OrderItemDTO;
import com.grasp.jagunap.entity.Order;
import com.grasp.jagunap.exception.OrderNotFoundException;
import com.grasp.jagunap.repository.OrderRepository;
import com.grasp.jagunap.util.NotificationStrategy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

// GRASP: Pure Fabrication — Service does not represent a real-world entity
// GRASP: High Cohesion — handles only business logic
// GRASP: Low Coupling — depends on interfaces, not concrete classes
@Service
public class OrderService {

    private final OrderRepository orderRepository;

    // GRASP: Low Coupling — injected as List<NotificationStrategy> interface
    // GRASP: Indirection — notification selected at runtime through map
    private final Map<String, NotificationStrategy> notificationStrategies;

    public OrderService(OrderRepository orderRepository,
                        List<NotificationStrategy> notifications) {
        this.orderRepository = orderRepository;
        this.notificationStrategies = notifications.stream()
                .collect(Collectors.toMap(
                        NotificationStrategy::getNotificationType,
                        Function.identity()));
    }

    // GRASP: Creator — Service builds Order and delegates item creation to Order
    public OrderDTO createOrder(OrderDTO dto) {
        if (dto.getCustomerName() == null || dto.getCustomerName().isBlank()) {
            throw new IllegalArgumentException("Customer name must not be empty");
        }
        if (dto.getItems() == null || dto.getItems().isEmpty()) {
            throw new IllegalArgumentException("Order must have at least one item");
        }

        Order order = new Order(dto.getCustomerName());

        for (OrderItemDTO item : dto.getItems()) {
            // GRASP: Creator — Order creates its own OrderItems
            order.addItem(item.getProductName(), item.getPrice(), item.getQuantity());
        }

        Order saved = orderRepository.save(order);
        return toDTO(saved);
    }

    public OrderDTO getOrderById(Long id) {
        Order order = orderRepository.findById(id)
                // GRASP: Protected Variations — throws custom exception
                .orElseThrow(() -> new OrderNotFoundException(id));
        return toDTO(order);
    }

    public List<OrderDTO> getAllOrders() {
        return orderRepository.findAll().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public void sendNotification(Long orderId, String type) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new OrderNotFoundException(orderId));

        // GRASP: Polymorphism — correct NotificationStrategy resolved at runtime
        NotificationStrategy strategy = notificationStrategies.get(type.toUpperCase());
        if (strategy == null) {
            throw new IllegalArgumentException("Unknown notification type: " + type);
        }

        // GRASP: Information Expert — order knows its own customer name
        strategy.sendNotification("Order for " + order.getCustomerName() + " is ready!");
    }

    public void deleteOrder(Long id) {
        if (!orderRepository.existsById(id)) {
            throw new OrderNotFoundException(id);
        }
        orderRepository.deleteById(id);
    }

    // GRASP: Information Expert — uses Order's own data to build DTO
    private OrderDTO toDTO(Order order) {
        return new OrderDTO(
                order.getId(),
                order.getCustomerName(),
                order.getStatus(),
                order.calculateTotal()
        );
    }
}