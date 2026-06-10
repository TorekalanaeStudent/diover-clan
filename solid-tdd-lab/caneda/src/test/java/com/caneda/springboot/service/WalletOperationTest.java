package com.caneda.springboot.service;

import com.caneda.springboot.dto.UserResponseDTO;
import com.caneda.springboot.service.interfaces.WalletOperation;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

// SOLID: LSP - proves both implementations are interchangeable
// TDD: tests written to prove polymorphism behavior
class WalletOperationTest {

    // SOLID: LSP - AddWalletOperation works correctly as WalletOperation
    @Test
    void shouldAddAmountCorrectly() {
        WalletOperation operation = new AddWalletOperation(50f);
        assertEquals(150f, operation.execute(100f));
    }

    // SOLID: LSP - DeductWalletOperation works correctly as WalletOperation
    @Test
    void shouldDeductAmountCorrectly() {
        WalletOperation operation = new DeductWalletOperation(50f);
        assertEquals(50f, operation.execute(100f));
    }

    // SOLID: LSP - both implementations interchangeable through same interface
    // OOP: Polymorphism - system works without changing core logic
    @Test
    void shouldWorkThroughInterface() {
        WalletOperation add = new AddWalletOperation(100f);
        WalletOperation deduct = new DeductWalletOperation(50f);

        assertEquals(200f, add.execute(100f));
        assertEquals(50f, deduct.execute(100f));
    }

    // Edge case: insufficient balance
    @Test
    void shouldThrowOnInsufficientBalance() {
        WalletOperation operation = new DeductWalletOperation(200f);
        assertThrows(IllegalArgumentException.class, () ->
                operation.execute(100f)
        );
    }

    // Edge case: add zero
    @Test
    void shouldHandleZeroAddAmount() {
        WalletOperation operation = new AddWalletOperation(0f);
        assertEquals(100f, operation.execute(100f));
    }

    // OOP: Immutability - DTO state is preserved after creation
    @Test
    void shouldPreserveImmutableDTOState() {
        UserResponseDTO dto = new UserResponseDTO(
                1L, "John", "john@email.com", 20, 100f
        );
        assertEquals(1L, dto.getId());
        assertEquals("John", dto.getUserName());
        assertEquals("john@email.com", dto.getUserEmail());
        assertEquals(20, dto.getUserAge());
        assertEquals(100f, dto.getUserWalletAmount());
        // OOP: Immutability - no setters exist to modify state
    }

    // OOP: Immutability - two DTOs with same values are consistent
    @Test
    void shouldCreateConsistentImmutableDTOState() {
        UserResponseDTO dto1 = new UserResponseDTO(
                1L, "John", "john@email.com", 20, 100f
        );
        UserResponseDTO dto2 = new UserResponseDTO(
                1L, "John", "john@email.com", 20, 100f
        );
        assertEquals(dto1.getUserName(), dto2.getUserName());
        assertEquals(dto1.getUserWalletAmount(), dto2.getUserWalletAmount());
    }
}