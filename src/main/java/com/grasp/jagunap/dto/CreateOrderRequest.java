package com.grasp.jagunap.dto;

import java.util.List;

public class CreateOrderRequest {
    private String customerName;
    private List<OrderItemDTO> items;
    private String paymentType; // CASH, CREDIT_CARD, GCASH

    public CreateOrderRequest() {}

    public String getCustomerName() { return customerName; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }
    public List<OrderItemDTO> getItems() { return items; }
    public void setItems(List<OrderItemDTO> items) { this.items = items; }
    public String getPaymentType() { return paymentType; }
    public void setPaymentType(String paymentType) { this.paymentType = paymentType; }
}
