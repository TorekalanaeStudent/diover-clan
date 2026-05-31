package com.obedoza.app.dto;

// OOP: Immutability - once created, this object cannot be changed
// SOLID: SRP - only carries order data, no logic
public record OrderSummary(Long id, String customerName, double total) {
    // Java records are immutable by default
    // YAGNI - only contains what's actually needed
}