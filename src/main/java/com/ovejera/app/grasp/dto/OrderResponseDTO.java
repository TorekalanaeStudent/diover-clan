package com.ovejera.app.grasp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class OrderResponseDTO {

    private Long orderId;

    private double total;
}