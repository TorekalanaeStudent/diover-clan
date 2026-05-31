package com.obedoza.app.Controller;


import com.obedoza.app.service.OrderService;
import com.obedoza.app.service.OrderServiceTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.http.MediaType;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.mockito.ArgumentMatchers.any;

import com.obedoza.app.dto.OrderResponse;
import com.obedoza.app.entity.Order;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;

@WebMvcTest
public class OrderControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private OrderService orderService;

    @Test
    void shouldReturnAllOrders() throws Exception {
        when(orderService.getAllOrders()).thenReturn(List.of());

        mockMvc.perform(get("/api/orders"))
                .andExpect(status().isOk());
    }

    @Test
    void shouldCreateOrder() throws Exception {
        OrderResponse response = OrderResponse.builder()
                .id(1L).customerName("Alice").status("PENDING").total(20.0).build();

        when(orderService.createOrder(any())).thenReturn(response);

        mockMvc.perform(post("/api/orders")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"customerName\":\"Alice\",\"items\":[]}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.customerName").value("Alice"));
    }

    @Test
    void shouldCalculateOrderTotal() {
        Order order = new Order();
        order.addItem("Widget", 2, 10.0); // 2 x $10 = $20
        order.addItem("Gadget", 1, 5.0);  // 1 x $5  = $5

        assertEquals(25.0, order.calculateTotal());
    }

    @Test
    void shouldGetOrderById() throws Exception {
        OrderResponse response = OrderResponse.builder()
                .id(1L)
                .customerName("Bob")
                .status("PENDING")
                .total(50.0)
                .build();

        when(orderService.getOrder(1L)).thenReturn(response);

        mockMvc.perform(get("/api/orders/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.customerName").value("Bob"));
    }

    @Test
    void shouldConfirmOrder() throws Exception {
        OrderResponse response = OrderResponse.builder()
                .id(1L)
                .customerName("Carol")
                .status("CONFIRMED")
                .total(30.0)
                .build();

        when(orderService.confirmOrder(1L)).thenReturn(response);

        mockMvc.perform(put("/api/orders/1/confirm"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value("CONFIRMED"));
    }

    @Test
    void shouldCancelOrder() throws Exception {
        mockMvc.perform(delete("/api/orders/1"))
                .andExpect(status().isNoContent());
    }
}
