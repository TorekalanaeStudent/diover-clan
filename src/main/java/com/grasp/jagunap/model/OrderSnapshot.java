package com.grasp.jagunap.model;

// OOP Best Practice: Immutability — once created, state cannot change
// SOLID: SRP — Represents a read-only snapshot of an order for reporting/audit
// KISS: Simple value object, no extra logic
public final class OrderSnapshot {

    // Immutability: all fields are final
    private final String customerName;
    private final double total;
    private final String status;
    private final int itemCount;

    public OrderSnapshot(String customerName, double total, String status, int itemCount) {
        this.customerName = customerName;
        this.total = total;
        this.status = status;
        this.itemCount = itemCount;
    }

    // No setters — immutable by design
    public String getCustomerName() { return customerName; }
    public double getTotal()        { return total; }
    public String getStatus()       { return status; }
    public int getItemCount()       { return itemCount; }
}