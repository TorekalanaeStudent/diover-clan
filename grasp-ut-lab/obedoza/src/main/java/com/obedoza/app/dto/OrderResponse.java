package com.obedoza.app.dto;

import lombok.*;
import java.time.LocalDateTime;

@Setter @Getter @NoArgsConstructor @AllArgsConstructor
@Builder
public class OrderResponse {
    private Long id;
    private String customerName;
    private String status;
    private double total;
    private LocalDateTime createdAt;
}
