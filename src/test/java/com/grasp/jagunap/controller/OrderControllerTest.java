package com.grasp.jagunap.controller;

import com.grasp.jagunap.dto.OrderDTO;
import com.grasp.jagunap.dto.OrderItemDTO;
import com.grasp.jagunap.exception.OrderNotFoundException;
import com.grasp.jagunap.service.OrderService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

// SOLID: SRP - Tests only controller layer behavior
// SOLID: DIP - OrderService is mocked, not a real instance
@ExtendWith(MockitoExtension.class)
class OrderControllerTest {

    @Mock
    private OrderService orderService;

    @InjectMocks
    private OrderController orderController;

    private OrderDTO sampleOrder;

    @BeforeEach
    void setUp() {
        sampleOrder = new OrderDTO(
                1L, "Juan", "PENDING",
                List.of(new OrderItemDTO(1L, "Laptop", 999.99, 1)),
                999.99
        );
    }

    @Test
    void shouldCreateOrderAndReturn201() {
        when(orderService.createOrder(any())).thenReturn(sampleOrder);

        ResponseEntity<OrderDTO> response = orderController.createOrder(any());

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals("Juan", response.getBody().getCustomerName());
    }

    @Test
    void shouldGetOrderByIdAndReturn200() {
        when(orderService.getOrderById(1L)).thenReturn(sampleOrder);

        ResponseEntity<OrderDTO> response = orderController.getOrder(1L);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Juan", response.getBody().getCustomerName());
    }

    @Test
    void shouldGetAllOrders() {
        List<OrderDTO> orders = List.of(
                sampleOrder,
                new OrderDTO(2L, "Maria", "COMPLETED", List.of(), 200.0)
        );
        when(orderService.getAllOrders()).thenReturn(orders);

        ResponseEntity<List<OrderDTO>> response = orderController.getAllOrders();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(2, response.getBody().size());
    }

    @Test
    void shouldDeleteOrderAndReturn204() {
        doNothing().when(orderService).deleteOrder(1L);

        ResponseEntity<Void> response = orderController.deleteOrder(1L);

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        verify(orderService, times(1)).deleteOrder(1L);
    }

    @Test
    void shouldReturn404WhenOrderNotFound() {
        when(orderService.getOrderById(99L))
                .thenThrow(new OrderNotFoundException(99L));

        assertThrows(OrderNotFoundException.class,
                () -> orderController.getOrder(99L));
    }
}