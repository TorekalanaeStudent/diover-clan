package com.grasp.jagunap.dto;

import java.util.List;

// GRASP: Pure Fabrication - DTO does not represent a domain concept,
// it exists purely for data transfer (decouples API from entity)
public class OrderDTO {
    private Long id;
    private String customerName;
    private String status;
    private List<OrderItemDTO> items;
    private double total;

    public OrderDTO() {}

    public OrderDTO(Long id, String customerName, String status, List<OrderItemDTO> items, double total) {
        this.id = id;
        this.customerName = customerName;
        this.status = status;
        this.items = items;
        this.total = total;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getCustomerName() { return customerName; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public List<OrderItemDTO> getItems() { return items; }
    public void setItems(List<OrderItemDTO> items) { this.items = items; }
    public double getTotal() { return total; }
    public void setTotal(double total) { this.total = total; }
}
