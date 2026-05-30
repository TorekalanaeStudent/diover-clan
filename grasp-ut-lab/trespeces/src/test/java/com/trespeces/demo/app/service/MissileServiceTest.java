package com.trespeces.demo.app.service;

import com.trespeces.demo.app.dto.MissileDTO;
import com.trespeces.demo.app.entity.Missile;
import com.trespeces.demo.app.repository.MissileRepository;
import com.trespeces.demo.app.util.LaunchMethod;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class MissileServiceTest {

    @Mock
    private MissileRepository missileRepository;

    @Mock
    private LaunchMethod airLaunch;

    @Mock
    private LaunchMethod seaLaunch;

    private MissileService missileService;

    @BeforeEach
    void setUp() {
        // GRASP: Low Coupling - depends on LaunchMethod interface, easy to mock
        Map<String, LaunchMethod> launchMethodMap = Map.of(
                "airLaunch", airLaunch,
                "seaLaunch", seaLaunch
        );
        missileService = new MissileService(missileRepository, launchMethodMap);
    }

    // Test 1: Create missile successfully
    @Test
    void shouldCreateMissileSuccessfully() {
        // Arrange
        Missile mockMissile = new Missile("Tomahawk", "CRUISE", 1000000.0, 5);
        when(missileRepository.save(any(Missile.class))).thenReturn(mockMissile);

        // Act
        MissileDTO result = missileService.createMissile("Tomahawk", "CRUISE", 1000000.0, 5);

        // Assert
        assertNotNull(result);
        assertEquals("Tomahawk", result.getName());
        assertEquals("PENDING", result.getStatus());
        verify(missileRepository, times(1)).save(any(Missile.class));
    }

    // Test 2: Throw exception when name is empty
    @Test
    void shouldThrowExceptionWhenNameIsEmpty() {
        assertThrows(IllegalArgumentException.class,
                () -> missileService.createMissile("", "CRUISE", 1000000.0, 5));
        verify(missileRepository, never()).save(any());
    }

    // Test 3: Throw exception when price is zero or negative
    @Test
    void shouldThrowExceptionWhenPriceIsInvalid() {
        assertThrows(IllegalArgumentException.class,
                () -> missileService.createMissile("Tomahawk", "CRUISE", 0, 5));
    }

    // Test 4: Throw exception when quantity is zero or negative
    @Test
    void shouldThrowExceptionWhenQuantityIsInvalid() {
        assertThrows(IllegalArgumentException.class,
                () -> missileService.createMissile("Tomahawk", "CRUISE", 1000000.0, 0));
    }

    // Test 5: Launch missile via air (Polymorphism test)
    @Test
    void shouldLaunchMissileViaAir() {
        // Arrange
        Missile mockMissile = new Missile("Tomahawk", "CRUISE", 1000000.0, 2);
        when(missileRepository.findById(1L)).thenReturn(Optional.of(mockMissile));
        when(missileRepository.save(any(Missile.class))).thenReturn(mockMissile);

        // Act
        MissileDTO result = missileService.launchMissile(1L, "air");

        // Assert
        assertEquals("LAUNCHED", result.getStatus());
        // GRASP: Polymorphism - verifies air launch was executed
        verify(airLaunch, times(1)).execute(2000000.0);
    }

    // Test 6: Launch missile via sea (Polymorphism test)
    @Test
    void shouldLaunchMissileViaSea() {
        // Arrange
        Missile mockMissile = new Missile("Patriot", "BALLISTIC", 500000.0, 3);
        when(missileRepository.findById(2L)).thenReturn(Optional.of(mockMissile));
        when(missileRepository.save(any(Missile.class))).thenReturn(mockMissile);

        // Act
        MissileDTO result = missileService.launchMissile(2L, "sea");

        // Assert
        assertEquals("LAUNCHED", result.getStatus());
        // GRASP: Polymorphism - verifies sea launch was executed
        verify(seaLaunch, times(1)).execute(1500000.0);
    }

    // Test 7: Throw exception when launching already launched missile
    @Test
    void shouldThrowExceptionWhenMissileAlreadyLaunched() {
        Missile mockMissile = new Missile("Tomahawk", "CRUISE", 1000000.0, 1);
        mockMissile.setStatus("LAUNCHED");
        when(missileRepository.findById(1L)).thenReturn(Optional.of(mockMissile));

        assertThrows(IllegalStateException.class,
                () -> missileService.launchMissile(1L, "air"));
    }

    // Test 8: Destroy missile successfully
    @Test
    void shouldDestroyMissileSuccessfully() {
        Missile mockMissile = new Missile("Tomahawk", "CRUISE", 1000000.0, 1);
        when(missileRepository.findById(1L)).thenReturn(Optional.of(mockMissile));
        when(missileRepository.save(any(Missile.class))).thenReturn(mockMissile);

        MissileDTO result = missileService.destroyMissile(1L);

        assertEquals("DESTROYED", result.getStatus());
    }

    // Test 9: Information Expert - Missile calculates correct total
    @Test
    void shouldCalculateMissileTotalCorrectly() {
        // Arrange
        Missile mockMissile = new Missile("Tomahawk", "CRUISE", 1000000.0, 3);
        when(missileRepository.save(any(Missile.class))).thenReturn(mockMissile);

        // Act
        MissileDTO result = missileService.createMissile("Tomahawk", "CRUISE", 1000000.0, 3);

        // Assert
        // GRASP: Information Expert - missile.calculateTotal() = 3000000.0
        assertEquals(3000000.0, result.getTotal());
    }
}