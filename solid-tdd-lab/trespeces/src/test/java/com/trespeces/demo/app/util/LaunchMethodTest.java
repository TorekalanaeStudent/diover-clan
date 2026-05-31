package com.trespeces.demo.app.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

// GRASP: Polymorphism - tests verify different LaunchMethod implementations
class LaunchMethodTest {

    // Test 1: AirLaunch returns correct type
    @Test
    void airLaunchShouldReturnCorrectType() {
        LaunchMethod launch = new AirLaunch();
        assertEquals("AIR", launch.getLaunchType());
    }

    // Test 2: SeaLaunch returns correct type
    @Test
    void seaLaunchShouldReturnCorrectType() {
        LaunchMethod launch = new SeaLaunch();
        assertEquals("SEA", launch.getLaunchType());
    }

    // Test 3: Polymorphism - both work through the same interface
    @Test
    void bothLaunchMethodsShouldExecuteWithoutException() {
        LaunchMethod air = new AirLaunch();
        LaunchMethod sea = new SeaLaunch();

        // GRASP: Polymorphism - same interface, different implementations
        assertDoesNotThrow(() -> air.execute(1000000.0));
        assertDoesNotThrow(() -> sea.execute(1000000.0));
    }
}