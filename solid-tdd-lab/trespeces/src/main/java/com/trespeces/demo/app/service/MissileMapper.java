package com.trespeces.demo.app.service;

import com.trespeces.demo.app.dto.MissileDTO;
import com.trespeces.demo.app.entity.Missile;

// SOLID: SRP - Handles only DTO conversion, nothing else
// KISS: Simple, straightforward mapping logic
// DRY: Centralized conversion, reusable across the app
public class MissileMapper {

    public MissileDTO toDTO(Missile missile) {
        return new MissileDTO(
                missile.getId(),
                missile.getName(),
                missile.getType(),
                missile.getPrice(),
                missile.getQuantity(),
                missile.getStatus(),
                missile.calculateTotal()
        );
    }
}
