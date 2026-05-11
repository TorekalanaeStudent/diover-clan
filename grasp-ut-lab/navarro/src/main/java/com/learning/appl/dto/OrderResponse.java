package com.learning.appl.dto;

import com.learning.appl.entity.Order;
import com.learning.appl.entity.OrderItem;
import com.learning.appl.entity.OrderStatus;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * GRASP: Low Coupling
 */

public class OrderResponse {

    private Long          id;
    private String        customerName;
    private OrderStatus   status;
    private double        total;
    private LocalDateTime createdAt;
    private List<ItemResponse> items;

    // ── Static factory (avoids exposing constructor complexity) ───────────────
    public static OrderResponse from(Order order) {
        OrderResponse resp = new OrderResponse();
        resp.id           = order.getId();
        resp.customerName = order.getCustomerName();
        resp.status       = order.getStatus();
        resp.total        = order.calculateTotal();
        resp.createdAt    = order.getCreatedAt();
        resp.items        = order.getItems().stream()
                .map(ItemResponse::from)
                .collect(Collectors.toList());
        return resp;
    }

    // ── Nested DTO ────────────────────────────────────────────────────────────
    public static class ItemResponse {
        private String productName;
        private int    quantity;
        private double unitPrice;
        private double subtotal;

        public static ItemResponse from(OrderItem i) {
            ItemResponse r = new ItemResponse();
            r.productName = i.getProductName();
            r.quantity    = i.getQuantity();
            r.unitPrice   = i.getUnitPrice();
            r.subtotal    = i.subtotal();
            return r;
        }

        public String getProductName() { return productName; }
        public int    getQuantity()    { return quantity; }
        public double getUnitPrice()   { return unitPrice; }
        public double getSubtotal()    { return subtotal; }
    }

    // ── Getters ───────────────────────────────────────────────────────────────
    public Long              getId()           { return id; }
    public String            getCustomerName() { return customerName; }
    public OrderStatus       getStatus()       { return status; }
    public double            getTotal()        { return total; }
    public LocalDateTime     getCreatedAt()    { return createdAt; }
    public List<ItemResponse> getItems()       { return items; }
}