package com.obedoza.app.dto;

import lombok.*;
import java.util.List;

// BONUS: DTO Pattern — separates API layer from entity layer
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class OrderRequest {
    private String customerName;
    private List<ItemRequest> items;

    @Setter @Getter @AllArgsConstructor @NoArgsConstructor
    public static class ItemRequest {
        private String productName;
        private int quantity;
        private double unitPrice;
    }
}
