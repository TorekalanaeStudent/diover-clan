package com.caneda.springboot.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseDTO {
    private Long id;
    private String userName;
    private String userEmail;
    private int userAge;
    private float userWalletAmount;
}