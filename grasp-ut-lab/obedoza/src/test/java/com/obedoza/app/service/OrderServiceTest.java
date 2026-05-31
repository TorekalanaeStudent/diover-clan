package com.obedoza.app.service;

import com.obedoza.app.dto.OrderRequest;
import com.obedoza.app.dto.OrderResponse;
import com.obedoza.app.entity.Order;
import com.obedoza.app.payment.PaymentProcessor;
import com.obedoza.app.repository.OrderRepository;
import com.obedoza.app.util.OrderValidator;

// JUnit 5
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

// Mockito
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.*;

// JUnit Assertions
import static org.junit.jupiter.api.Assertions.*;

// Java
import java.time.LocalDateTime;
import java.util.*;

@ExtendWith(MockitoExtension.class)
public class OrderServiceTest {
    @Mock
    private OrderRepository orderRepository;

    @Mock
    private OrderValidator orderValidator;

    @Mock
    private PaymentProcessor creditCardPayment;

    @InjectMocks
    private OrderServiceImplimentation orderService;

    // We need to inject the map of payment processors manually
    @BeforeEach
    void setup() {
        Map<String, PaymentProcessor> processors = new HashMap<>();
        processors.put("creditCard", creditCardPayment);
        // Re-create the service with our mock map
        orderService = new OrderServiceImplimentation(orderRepository, orderValidator, processors);
    }


    @Test
    void shouldCreateOrderSuccessfully() {
        // Arrange
        OrderRequest request = buildRequest("Alice");

        Order savedOrder = buildOrder(1L, "Alice", "PENDING");
        when(orderRepository.save(any(Order.class))).thenReturn(savedOrder);

        // Act
        OrderResponse response = orderService.createOrder(request);

        // Assert
        assertNotNull(response);
        assertEquals("Alice", response.getCustomerName());
        assertEquals("PENDING", response.getStatus());
        verify(orderValidator, times(1)).validate(request); // validator was called
        verify(orderRepository, times(1)).save(any(Order.class));
    }

    // Test 2: getOrder — order exists
    @Test
    void shouldReturnOrderWhenFound() {
        // Arrange
        Order order = buildOrder(1L, "Bob", "PENDING");
        when(orderRepository.findById(1L)).thenReturn(Optional.of(order));

        // Act
        OrderResponse response = orderService.getOrder(1L);

        // Assert
        assertEquals("Bob", response.getCustomerName());
        assertEquals(1L, response.getId());
    }
    // Test 3: getOrder — order NOT found (edge case)
    @Test
    void shouldThrowWhenOrderNotFound() {
        // Arrange
        when(orderRepository.findById(99L)).thenReturn(Optional.empty());

        // Act & Assert
        RuntimeException ex = assertThrows(RuntimeException.class,
                () -> orderService.getOrder(99L));
        assertTrue(ex.getMessage().contains("Order not found"));
    }

    // Test 4: confirmOrder — processes payment and changes status
    @Test
    void shouldConfirmPendingOrder() {
        // Arrange
        Order order = buildOrder(1L, "Carol", "PENDING");
        when(orderRepository.findById(1L)).thenReturn(Optional.of(order));
        when(orderRepository.save(any(Order.class))).thenReturn(order);

        // Act
        orderService.confirmOrder(1L);

        // Assert
        verify(creditCardPayment, times(1)).process(anyDouble());
        assertEquals("CONFIRMED", order.getStatus());
    }

    // Test 5: confirmOrder — already confirmed (edge case)
    @Test
    void shouldThrowWhenConfirmingNonPendingOrder() {
        // Arrange
        Order order = buildOrder(1L, "Dave", "CONFIRMED");
        when(orderRepository.findById(1L)).thenReturn(Optional.of(order));

        // Act & Assert
        assertThrows(IllegalStateException.class, () -> orderService.confirmOrder(1L));
        verify(creditCardPayment, never()).process(anyDouble()); // payment never called
    }

    // Test 6: cancelOrder — confirmed orders can't be cancelled (edge case)
    @Test
    void shouldThrowWhenCancellingConfirmedOrder() {
        Order order = buildOrder(1L, "Eve", "CONFIRMED");
        when(orderRepository.findById(1L)).thenReturn(Optional.of(order));

        assertThrows(IllegalStateException.class, () -> orderService.cancelOrder(1L));
    }

    // Test 7: getAllOrders — empty list (edge case)
    @Test
    void shouldReturnEmptyListWhenNoOrders() {
        when(orderRepository.findAll()).thenReturn(Collections.emptyList());
        List<OrderResponse> result = orderService.getAllOrders();
        assertTrue(result.isEmpty());
    }

    private OrderRequest buildRequest(String name) {
        OrderRequest.ItemRequest item = new OrderRequest.ItemRequest("Widget", 2, 10.0);
        return new OrderRequest(name, List.of(item));
    }

    private Order buildOrder(Long id, String customer, String status) {
        Order order = new Order();
        order.setId(id);
        order.setCustomerName(customer);
        order.setStatus(status);
        order.setCreatedAt(LocalDateTime.now());
        return order;
    }

    @Test
    void shouldCancelPendingOrder() {
        Order order = buildOrder(1L, "Frank", "PENDING");
        when(orderRepository.findById(1L)).thenReturn(Optional.of(order));
        when(orderRepository.save(any())).thenReturn(order);

        orderService.cancelOrder(1L);

        assertEquals("CANCELLED", order.getStatus());
    }

}
