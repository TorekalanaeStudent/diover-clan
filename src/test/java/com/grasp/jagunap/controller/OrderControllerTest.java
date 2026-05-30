package com.grasp.jagunap.controller;

import com.grasp.jagunap.dto.OrderDTO;
import com.grasp.jagunap.dto.OrderItemDTO;
import com.grasp.jagunap.exception.GlobalExceptionHandler;
import com.grasp.jagunap.exception.OrderNotFoundException;
import com.grasp.jagunap.service.OrderService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

// GRASP: Controller tests — verifies HTTP behavior only
@WebMvcTest(controllers = {OrderController.class, GlobalExceptionHandler.class})
class OrderControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private OrderService orderService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void shouldReturn201WhenCreatingOrder() throws Exception {
        OrderDTO response = new OrderDTO(1L, "Janelle", "PENDING", 200.0);
        when(orderService.createOrder(any())).thenReturn(response);

        mockMvc.perform(post("/api/orders")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(makeOrderDTO())))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.customerName").value("Janelle"));
    }

    @Test
    void shouldReturn200WhenGettingAllOrders() throws Exception {
        when(orderService.getAllOrders()).thenReturn(List.of());

        mockMvc.perform(get("/api/orders"))
                .andExpect(status().isOk());
    }

    @Test
    void shouldReturn200WhenGettingOrderById() throws Exception {
        OrderDTO response = new OrderDTO(1L, "Janelle", "PENDING", 100.0);
        when(orderService.getOrderById(1L)).thenReturn(response);

        mockMvc.perform(get("/api/orders/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.customerName").value("Janelle"));
    }

    @Test
    void shouldReturn404WhenOrderNotFound() throws Exception {
        when(orderService.getOrderById(99L))
                .thenThrow(new OrderNotFoundException(99L));

        mockMvc.perform(get("/api/orders/99"))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.error").exists());
    }

    @Test
    void shouldReturn204WhenDeletingOrder() throws Exception {
        doNothing().when(orderService).deleteOrder(1L);

        mockMvc.perform(delete("/api/orders/1"))
                .andExpect(status().isNoContent());
    }

    @Test
    void shouldReturn200WhenNotificationSent() throws Exception {
        doNothing().when(orderService).sendNotification(1L, "EMAIL");

        mockMvc.perform(post("/api/orders/1/notify")
                        .param("type", "EMAIL"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message").value("Notification sent successfully"));
    }

    private OrderDTO makeOrderDTO() {
        OrderItemDTO item = new OrderItemDTO("Bag", 100.0, 2);
        OrderDTO dto = new OrderDTO();
        dto.setCustomerName("Janelle");
        dto.setItems(List.of(item));
        return dto;
    }
}