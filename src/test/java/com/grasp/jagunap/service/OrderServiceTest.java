package com.grasp.jagunap.service;

import com.grasp.jagunap.dto.CreateOrderRequest;
import com.grasp.jagunap.dto.OrderDTO;
import com.grasp.jagunap.dto.OrderItemDTO;
import com.grasp.jagunap.entity.Order;
import com.grasp.jagunap.entity.OrderItem;
import com.grasp.jagunap.exception.OrderNotFoundException;
import com.grasp.jagunap.repository.OrderRepository;
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

    // SOLID: DIP - mocking abstractions, not concrete classes
    private OrderValidator orderValidator;
    private OrderMapper orderMapper;
    private PaymentResolver paymentResolver;
    private OrderService orderService;

    @BeforeEach
    void setUp() {
        orderValidator = new OrderValidator();
        orderMapper = new OrderMapper();

        // OCP: PaymentResolver with no payments (we test payment separately)
        paymentResolver = new PaymentResolver(java.util.Map.of());

        // DIP: Inject all dependencies via constructor
        orderService = new OrderService(
                orderRepository,
                orderValidator,
                paymentResolver,
                orderMapper
        );
    }

    // ✅ Test 1: Should create order successfully
    @Test
    void shouldCreateOrderSuccessfully() {
        CreateOrderRequest request = buildRequest("John Doe", "Laptop", 999.99, 1);

        Order savedOrder = new Order("John Doe");
        savedOrder.addItem(new OrderItem("Laptop", 999.99, 1));
        when(orderRepository.save(any(Order.class))).thenReturn(savedOrder);

        OrderDTO result = orderService.createOrder(request);

        assertNotNull(result);
        assertEquals("John Doe", result.getCustomerName());
        assertEquals("PENDING", result.getStatus());
        assertEquals(999.99, result.getTotal());
        verify(orderRepository, times(1)).save(any(Order.class));
    }

    // ✅ Test 2: Should throw when customer name is empty
    @Test
    void shouldThrowExceptionWhenCustomerNameIsEmpty() {
        CreateOrderRequest request = new CreateOrderRequest();
        request.setCustomerName("");
        request.setItems(List.of(new OrderItemDTO(null, "Laptop", 100.0, 1)));

        assertThrows(IllegalArgumentException.class,
                () -> orderService.createOrder(request));
        verify(orderRepository, never()).save(any());
    }

    // ✅ Test 3: Should throw when items are empty
    @Test
    void shouldThrowExceptionWhenItemsAreEmpty() {
        CreateOrderRequest request = new CreateOrderRequest();
        request.setCustomerName("Jane");
        request.setItems(List.of());

        assertThrows(IllegalArgumentException.class,
                () -> orderService.createOrder(request));
        verify(orderRepository, never()).save(any());
    }

    // ✅ Test 4: Should get order by ID
    @Test
    void shouldGetOrderById() {
        Order order = new Order("Alice");
        order.addItem(new OrderItem("Phone", 500.0, 2));
        when(orderRepository.findById(1L)).thenReturn(Optional.of(order));

        OrderDTO result = orderService.getOrderById(1L);

        assertNotNull(result);
        assertEquals("Alice", result.getCustomerName());
        assertEquals(1000.0, result.getTotal());
    }

    // ✅ Test 5: Should throw OrderNotFoundException
    @Test
    void shouldThrowOrderNotFoundExceptionWhenOrderDoesNotExist() {
        when(orderRepository.findById(99L)).thenReturn(Optional.empty());

        assertThrows(OrderNotFoundException.class,
                () -> orderService.getOrderById(99L));
    }

    // ✅ Test 6: Should return all orders
    @Test
    void shouldReturnAllOrders() {
        Order order1 = new Order("Alice");
        order1.addItem(new OrderItem("Item1", 100.0, 1));
        Order order2 = new Order("Bob");
        order2.addItem(new OrderItem("Item2", 200.0, 2));
        when(orderRepository.findAll()).thenReturn(List.of(order1, order2));

        List<OrderDTO> results = orderService.getAllOrders();

        assertEquals(2, results.size());
    }

    // ✅ Test 7: Should update order status
    @Test
    void shouldUpdateOrderStatus() {
        Order order = new Order("Alice");
        order.addItem(new OrderItem("Item", 50.0, 1));
        when(orderRepository.findById(1L)).thenReturn(Optional.of(order));
        when(orderRepository.save(any(Order.class))).thenReturn(order);

        OrderDTO result = orderService.updateOrderStatus(1L, "COMPLETED");

        assertEquals("COMPLETED", result.getStatus());
        verify(orderRepository, times(1)).save(order);
    }

    // ✅ Test 8: Should delete order successfully
    @Test
    void shouldDeleteOrderSuccessfully() {
        when(orderRepository.existsById(1L)).thenReturn(true);

        orderService.deleteOrder(1L);

        verify(orderRepository, times(1)).deleteById(1L);
    }

    // ✅ Test 9: Should throw when deleting non-existent order
    @Test
    void shouldThrowWhenDeletingNonExistentOrder() {
        when(orderRepository.existsById(99L)).thenReturn(false);

        assertThrows(OrderNotFoundException.class,
                () -> orderService.deleteOrder(99L));
    }

    // ✅ Test 10: Should calculate correct total for multiple items
    @Test
    void shouldCalculateCorrectTotalForMultipleItems() {
        CreateOrderRequest request = new CreateOrderRequest();
        request.setCustomerName("Bob");
        request.setItems(List.of(
                new OrderItemDTO(null, "Item A", 100.0, 2),  // 200
                new OrderItemDTO(null, "Item B", 50.0, 3)    // 150
        ));

        Order savedOrder = new Order("Bob");
        savedOrder.addItem(new OrderItem("Item A", 100.0, 2));
        savedOrder.addItem(new OrderItem("Item B", 50.0, 3));
        when(orderRepository.save(any(Order.class))).thenReturn(savedOrder);

        OrderDTO result = orderService.createOrder(request);

        assertEquals(350.0, result.getTotal());
    }

    // Helper
    private CreateOrderRequest buildRequest(String customer, String product,
                                            double price, int qty) {
        CreateOrderRequest request = new CreateOrderRequest();
        request.setCustomerName(customer);
        request.setItems(List.of(new OrderItemDTO(null, product, price, qty)));
        return request;
    }
}