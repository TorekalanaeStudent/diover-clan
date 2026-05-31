package com.ovejera.app.grasp.service;

import com.ovejera.app.grasp.entity.Order;
import com.ovejera.app.grasp.exception.OrderNotFoundException;
import com.ovejera.app.grasp.repository.OrderRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OrderServiceTest {

    @Mock
    private OrderRepository repository;

    @Mock
    private PaymentStrategy paymentStrategy;

    @InjectMocks
    private OrderService service;

    @Test
    void shouldCreateOrder() {

        Order order = new Order();

        when(repository.save(order))
                .thenReturn(order);

        Order result = service.createOrder(order);

        assertNotNull(result);

        verify(repository).save(order);
    }

    @Test
    void shouldGetOrder() {

        Order order = new Order();

        when(repository.findById(1L))
                .thenReturn(Optional.of(order));

        Order result = service.getOrder(1L);

        assertEquals(order, result);
    }

    @Test
    void shouldThrowWhenOrderNotFound() {

        when(repository.findById(1L))
                .thenReturn(Optional.empty());

        assertThrows(
                OrderNotFoundException.class,
                () -> service.getOrder(1L));
    }

    @Test
    void shouldProcessPayment() {

        Order order = new Order();

        when(repository.save(order))
                .thenReturn(order);

        service.createOrder(order);

        verify(paymentStrategy)
                .processPayment(anyDouble());
    }

    @Test
    void shouldNotReturnNullOrder() {

        Order order = new Order();

        when(repository.findById(1L))
                .thenReturn(Optional.of(order));

        assertNotNull(service.getOrder(1L));
    }
}