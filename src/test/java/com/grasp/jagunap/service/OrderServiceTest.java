package com.grasp.jagunap.service;

import com.grasp.jagunap.dto.OrderDTO;
import com.grasp.jagunap.dto.OrderItemDTO;
import com.grasp.jagunap.entity.Order;
import com.grasp.jagunap.exception.OrderNotFoundException;
import com.grasp.jagunap.repository.OrderRepository;
import com.grasp.jagunap.util.EmailNotification;
import com.grasp.jagunap.util.NotificationStrategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OrderServiceTest {

    @Mock
    private OrderRepository orderRepository;

    private OrderService orderService;

    @BeforeEach
    void setUp() {
        List<NotificationStrategy> notifications = List.of(new EmailNotification());
        orderService = new OrderService(orderRepository, notifications);
    }

    // ✅ Test 1: Should create order successfully
    @Test
    void shouldCreateOrder() {
        OrderDTO dto = makeOrderDTO("Janelle");
        Order saved = new Order("Janelle");
        saved.addItem("Laptop", 999.99, 1);
        when(orderRepository.save(any(Order.class))).thenReturn(saved);

        OrderDTO result = orderService.createOrder(dto);

        assertNotNull(result);
        assertEquals("Janelle", result.getCustomerName());
        verify(orderRepository, times(1)).save(any(Order.class));
    }

    // ✅ Test 2: Should throw when order not found
    @Test
    void shouldThrowWhenOrderNotFound() {
        when(orderRepository.findById(99L)).thenReturn(Optional.empty());

        assertThrows(OrderNotFoundException.class,
                () -> orderService.getOrderById(99L));
    }

    // ✅ Test 3: Should return all orders
    @Test
    void shouldReturnAllOrders() {
        Order o1 = new Order("Ana");
        Order o2 = new Order("Bob");
        when(orderRepository.findAll()).thenReturn(List.of(o1, o2));

        List<OrderDTO> result = orderService.getAllOrders();

        assertEquals(2, result.size());
    }

    // ✅ Test 4: Edge case — empty customer name
    @Test
    void shouldRejectEmptyCustomerName() {
        OrderDTO dto = new OrderDTO();
        dto.setCustomerName("");
        dto.setItems(List.of(new OrderItemDTO("Pen", 10.0, 1)));

        assertThrows(IllegalArgumentException.class,
                () -> orderService.createOrder(dto));
        verify(orderRepository, never()).save(any());
    }

    // ✅ Test 5: Edge case — null items
    @Test
    void shouldRejectNullItems() {
        OrderDTO dto = new OrderDTO();
        dto.setCustomerName("Janelle");
        dto.setItems(null);

        assertThrows(IllegalArgumentException.class,
                () -> orderService.createOrder(dto));
    }

    // ✅ Test 6: Should send email notification
    @Test
    void shouldSendEmailNotification() {
        Order order = new Order("Janelle");
        order.addItem("Book", 100.0, 1);
        when(orderRepository.findById(1L)).thenReturn(Optional.of(order));

        assertDoesNotThrow(() -> orderService.sendNotification(1L, "EMAIL"));
    }

    // ✅ Test 7: Should throw on unknown notification type
    @Test
    void shouldThrowOnUnknownNotificationType() {
        Order order = new Order("Janelle");
        when(orderRepository.findById(1L)).thenReturn(Optional.of(order));

        assertThrows(IllegalArgumentException.class,
                () -> orderService.sendNotification(1L, "UNKNOWN"));
    }

    // ✅ Test 8: Should delete order
    @Test
    void shouldDeleteOrder() {
        when(orderRepository.existsById(1L)).thenReturn(true);
        doNothing().when(orderRepository).deleteById(1L);

        orderService.deleteOrder(1L);

        verify(orderRepository).deleteById(1L);
    }

    // ✅ Test 9: Should throw when deleting non-existent order
    @Test
    void shouldThrowWhenDeletingNonExistentOrder() {
        when(orderRepository.existsById(99L)).thenReturn(false);

        assertThrows(OrderNotFoundException.class,
                () -> orderService.deleteOrder(99L));
    }

    // ✅ Test 10: Should return correct total
    @Test
    void shouldReturnCorrectTotal() {
        OrderDTO dto = makeOrderDTO("Janelle");
        Order saved = new Order("Janelle");
        saved.addItem("Monitor", 200.0, 2); // total = 400.0
        when(orderRepository.save(any(Order.class))).thenReturn(saved);

        OrderDTO result = orderService.createOrder(dto);

        assertEquals(400.0, result.getTotal(), 0.001);
    }

    private OrderDTO makeOrderDTO(String customerName) {
        OrderItemDTO item = new OrderItemDTO("Laptop", 999.99, 1);
        OrderDTO dto = new OrderDTO();
        dto.setCustomerName(customerName);
        dto.setItems(List.of(item));
        return dto;
    }
}