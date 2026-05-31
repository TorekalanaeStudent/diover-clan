package com.ovejera.app.grasp.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderRequestDTO {

    private Long productId;

    private int quantity;
}