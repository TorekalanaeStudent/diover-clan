package com.grasp.jagunap.service;

import com.grasp.jagunap.dto.CreateOrderRequest;
import com.grasp.jagunap.dto.OrderDTO;
import com.grasp.jagunap.dto.OrderItemDTO;
import com.grasp.jagunap.entity.Order;
import com.grasp.jagunap.entity.OrderItem;
import com.grasp.jagunap.exception.OrderNotFoundException;
import com.grasp.jagunap.payment.Payment;
import com.grasp.jagunap.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

// SOLID: SRP - Only orchestrates order flow; validation/mapping/payment are delegated
// SOLID: DIP - Depends on abstractions (interfaces + injected components), not concrete classes
// OOP: Composition over Inheritance — uses injected collaborators (HAS-A, not IS-A)
// KISS: Each method does one clear thing
@Service
public class OrderService {

    // DIP: All dependencies are abstractions injected from outside
    private final OrderRepository orderRepository;
    private final OrderValidator orderValidator;     // SRP: validation extracted
    private final PaymentResolver paymentResolver;   // OCP: no more switch statement
    private final OrderMapper orderMapper;           // SRP: mapping extracted

    public OrderService(OrderRepository orderRepository,
                        OrderValidator orderValidator,
                        PaymentResolver paymentResolver,
                        OrderMapper orderMapper) {
        this.orderRepository = orderRepository;
        this.orderValidator = orderValidator;
        this.paymentResolver = paymentResolver;
        this.orderMapper = orderMapper;
    }

    public OrderDTO createOrder(CreateOrderRequest request) {
        // SRP: Validation is fully delegated — not mixed here
        orderValidator.validate(request);

        Order order = new Order(request.getCustomerName());
        for (OrderItemDTO itemDTO : request.getItems()) {
            order.addItem(new OrderItem(
                    itemDTO.getProductName(),
                    itemDTO.getPrice(),
                    itemDTO.getQuantity()
            ));
        }

        Order saved = orderRepository.save(order);

        // OCP: PaymentResolver handles type lookup — adding a new type never touches this method
        if (request.getPaymentType() != null) {
            Payment payment = paymentResolver.resolve(request.getPaymentType());
            if (payment != null) {
                payment.process(saved.calculateTotal());
            }
        }

        // SRP: Mapping is fully delegated
        return orderMapper.toDTO(saved);
    }

    public OrderDTO getOrderById(Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new OrderNotFoundException(id));
        return orderMapper.toDTO(order);
    }

    public List<OrderDTO> getAllOrders() {
        return orderRepository.findAll().stream()
                .map(orderMapper::toDTO)
                .collect(Collectors.toList());
    }

    public OrderDTO updateOrderStatus(Long id, String status) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new OrderNotFoundException(id));
        order.setStatus(status);
        return orderMapper.toDTO(orderRepository.save(order));
    }

    public void deleteOrder(Long id) {
        if (!orderRepository.existsById(id)) {
            throw new OrderNotFoundException(id);
        }
        orderRepository.deleteById(id);
    }

    public List<OrderDTO> getOrdersByCustomer(String customerName) {
        return orderRepository.findByCustomerName(customerName).stream()
                .map(orderMapper::toDTO)
                .collect(Collectors.toList());
    }
}