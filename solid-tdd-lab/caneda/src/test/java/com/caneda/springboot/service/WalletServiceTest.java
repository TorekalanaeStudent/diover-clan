package com.caneda.springboot.service;

import com.caneda.springboot.dto.UserResponseDTO;
import com.caneda.springboot.entity.User;
import com.caneda.springboot.exception.UserNotFoundException;
import com.caneda.springboot.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class WalletServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private UserValidationService validator;

    @InjectMocks
    private WalletService walletService;

    @Test
    void shouldAddToWallet() {
        // Arrange
        User user = new User(1L, "John", "john@email.com", 20, 100f);
        when(userRepository.findById(1L)).thenReturn(Optional.of(user));
        when(userRepository.save(any(User.class))).thenReturn(user);

        // Act
        UserResponseDTO result = walletService.processWallet(
                1L, 50f, new AddWalletOperation(50f)
        );

        // Assert
        assertNotNull(result);
        assertEquals(150f, result.getUserWalletAmount());
    }

    @Test
    void shouldDeductFromWallet() {
        // Arrange
        User user = new User(1L, "John", "john@email.com", 20, 100f);
        when(userRepository.findById(1L)).thenReturn(Optional.of(user));
        when(userRepository.save(any(User.class))).thenReturn(user);

        // Act
        UserResponseDTO result = walletService.processWallet(
                1L, 50f, new DeductWalletOperation(50f)
        );

        // Assert
        assertNotNull(result);
        assertEquals(50f, result.getUserWalletAmount());
    }

    @Test
    void shouldThrowWhenInsufficientBalance() {
        // Arrange
        User user = new User(1L, "John", "john@email.com", 20, 50f);
        when(userRepository.findById(1L)).thenReturn(Optional.of(user));

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            walletService.processWallet(1L, 100f, new DeductWalletOperation(100f));
        });
    }

    @Test
    void shouldThrowWhenUserNotFoundForWallet() {
        // Arrange
        when(userRepository.findById(99L)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(UserNotFoundException.class, () -> {
            walletService.processWallet(99L, 50f, new AddWalletOperation(50f));
        });
    }
}