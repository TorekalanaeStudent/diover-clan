package com.learning.appl;

import com.learning.appl.controller.OrderController;
import com.learning.appl.dto.OrderRequest;
import com.learning.appl.dto.OrderResponse;
import com.learning.appl.entity.Order;
import com.learning.appl.entity.OrderStatus;
import com.learning.appl.service.OrderService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class OrderControllerTest {

    private final OrderService orderService = mock(OrderService.class);
    private final OrderController controller = new OrderController(orderService);

    @Test
    @DisplayName("Controller delegates create order and returns CREATED")
    void shouldCreateOrder() {
        OrderRequest request = new OrderRequest();
        OrderResponse response = response("Alice", OrderStatus.CONFIRMED);
        when(orderService.createOrder(request)).thenReturn(response);

        ResponseEntity<OrderResponse> result = controller.createOrder(request);

        assertThat(result.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        assertThat(result.getBody()).isSameAs(response);
        verify(orderService).createOrder(request);
    }

    @Test
    @DisplayName("Controller delegates get all orders")
    void shouldGetAllOrders() {
        List<OrderResponse> responses = List.of(response("Alice", OrderStatus.CONFIRMED));
        when(orderService.getAllOrders()).thenReturn(responses);

        ResponseEntity<List<OrderResponse>> result = controller.getAllOrders();

        assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(result.getBody()).isEqualTo(responses);
        verify(orderService).getAllOrders();
    }

    @Test
    @DisplayName("Controller delegates get order by id")
    void shouldGetOrderById() {
        OrderResponse response = response("Bob", OrderStatus.PENDING);
        when(orderService.getOrderById(7L)).thenReturn(response);

        ResponseEntity<OrderResponse> result = controller.getOrderById(7L);

        assertThat(result.getBody()).isSameAs(response);
        verify(orderService).getOrderById(7L);
    }

    @Test
    @DisplayName("Controller delegates customer search")
    void shouldGetByCustomer() {
        List<OrderResponse> responses = List.of(response("Carol", OrderStatus.CONFIRMED));
        when(orderService.getOrdersByCustomer("Carol")).thenReturn(responses);

        ResponseEntity<List<OrderResponse>> result = controller.getByCustomer("Carol");

        assertThat(result.getBody()).isEqualTo(responses);
        verify(orderService).getOrdersByCustomer("Carol");
    }

    @Test
    @DisplayName("Controller delegates status update")
    void shouldUpdateStatus() {
        OrderResponse response = response("Dave", OrderStatus.SHIPPED);
        when(orderService.updateStatus(3L, OrderStatus.SHIPPED)).thenReturn(response);

        ResponseEntity<OrderResponse> result = controller.updateStatus(3L, OrderStatus.SHIPPED);

        assertThat(result.getBody()).isSameAs(response);
        verify(orderService).updateStatus(3L, OrderStatus.SHIPPED);
    }

    @Test
    @DisplayName("Controller delegates cancellation and returns NO_CONTENT")
    void shouldCancelOrder() {
        ResponseEntity<Void> result = controller.cancelOrder(4L);

        assertThat(result.getStatusCode()).isEqualTo(HttpStatus.NO_CONTENT);
        verify(orderService).cancelOrder(4L);
    }

    private OrderResponse response(String customerName, OrderStatus status) {
        Order order = new Order(customerName);
        order.addItem("Widget", 1, 10.00);
        order.setStatus(status);
        return OrderResponse.from(order);
    }
}
