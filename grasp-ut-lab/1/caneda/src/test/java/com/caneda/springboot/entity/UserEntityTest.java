package com.caneda.springboot.entity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserEntityTest {

    @Test
    void shouldApplyWalletAmount() {
        User user = new User(1L, "John", "john@email.com", 20, 100f);
        user.applyWalletAmount(200f);
        assertEquals(200f, user.getUserWalletAmount());
    }

    @Test
    void shouldReturnTrueWhenSufficientBalance() {
        User user = new User(1L, "John", "john@email.com", 20, 100f);
        assertTrue(user.hasSufficientBalance(50f));
    }

    @Test
    void shouldReturnFalseWhenInsufficientBalance() {
        User user = new User(1L, "John", "john@email.com", 20, 50f);
        assertFalse(user.hasSufficientBalance(100f));
    }

    @Test
    void shouldReturnTrueWhenUserIsValid() {
        User user = new User(1L, "John", "john@email.com", 20, 0f);
        assertTrue(user.isValidUser());
    }

    @Test
    void shouldReturnFalseWhenUserIsInvalid() {
        User user = new User();
        assertFalse(user.isValidUser());
    }
}