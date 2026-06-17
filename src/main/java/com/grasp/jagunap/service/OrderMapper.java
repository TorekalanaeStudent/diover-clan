package com.grasp.jagunap.service;

import com.grasp.jagunap.dto.OrderDTO;
import com.grasp.jagunap.dto.OrderItemDTO;
import com.grasp.jagunap.entity.Order;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

// SOLID: SRP - Only responsible for mapping Order entities to DTOs
// SOLID: OCP - Add new mapping targets here without changing OrderService
// DRY: One place for mapping logic, reused wherever needed
@Component
public class OrderMapper {

    public OrderDTO toDTO(Order order) {
        List<OrderItemDTO> itemDTOs = order.getItems().stream()
                .map(item -> new OrderItemDTO(
                        item.getId(),
                        item.getProductName(),
                        item.getPrice(),
                        item.getQuantity()
                ))
                .collect(Collectors.toList());

        return new OrderDTO(
                order.getId(),
                order.getCustomerName(),
                order.getStatus(),
                itemDTOs,
                order.calculateTotal()
        );
    }
}