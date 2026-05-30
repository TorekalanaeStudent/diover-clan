package com.learning.appl.dto;

import com.learning.appl.entity.Order;
import com.learning.appl.entity.OrderItem;
import com.learning.appl.entity.OrderStatus;

import java.time.LocalDateTime;
import java.util.List;

/**
 * DTO Pattern: keeps the API response separate from JPA entities.
 *
 * OOP: Immutability - response state is fully built in the factory method and
 * exposed through getters only.
 */
public final class OrderResponse {

    private final Long id;
    private final String customerName;
    private final OrderStatus status;
    private final double total;
    private final LocalDateTime createdAt;
    private final List<ItemResponse> items;

    private OrderResponse(
            Long id,
            String customerName,
            OrderStatus status,
            double total,
            LocalDateTime createdAt,
            List<ItemResponse> items) {
        this.id = id;
        this.customerName = customerName;
        this.status = status;
        this.total = total;
        this.createdAt = createdAt;
        this.items = List.copyOf(items);
    }

    // SOLID: SRP - maps an Order into an API response without persistence or HTTP logic.
    public static OrderResponse from(Order order) {
        List<ItemResponse> itemResponses = order.getItems().stream()
                .map(ItemResponse::from)
                .toList();

        return new OrderResponse(
                order.getId(),
                order.getCustomerName(),
                order.getStatus(),
                order.calculateTotal(),
                order.getCreatedAt(),
                itemResponses);
    }

    public Long getId() {
        return id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public double getTotal() {
        return total;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public List<ItemResponse> getItems() {
        return items;
    }

    public static final class ItemResponse {
        private final String productName;
        private final int quantity;
        private final double unitPrice;
        private final double subtotal;

        private ItemResponse(String productName, int quantity, double unitPrice, double subtotal) {
            this.productName = productName;
            this.quantity = quantity;
            this.unitPrice = unitPrice;
            this.subtotal = subtotal;
        }

        public static ItemResponse from(OrderItem item) {
            return new ItemResponse(
                    item.getProductName(),
                    item.getQuantity(),
                    item.getUnitPrice(),
                    item.subtotal());
        }

        public String getProductName() {
            return productName;
        }

        public int getQuantity() {
            return quantity;
        }

        public double getUnitPrice() {
            return unitPrice;
        }

        public double getSubtotal() {
            return subtotal;
        }
    }
}
