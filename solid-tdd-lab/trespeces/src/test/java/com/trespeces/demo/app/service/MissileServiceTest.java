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

import java.util.ArrayList;
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
        Map<String, LaunchMethod> launchMethodMap = Map.of(
                "airLaunch", airLaunch,
                "seaLaunch", seaLaunch
        );
        missileService = new MissileService(missileRepository, launchMethodMap);
    }

    // Test 1: Create missile successfully
    @Test
    void shouldCreateMissileSuccessfully() {
        Missile mockMissile = new Missile("Tomahawk", "CRUISE", 1000000.0, 5);
        when(missileRepository.save(any(Missile.class))).thenReturn(mockMissile);

        MissileDTO result = missileService.createMissile("Tomahawk", "CRUISE", 1000000.0, 5);

        assertNotNull(result);
        assertEquals("Tomahawk", result.getName());
        assertEquals("PENDING", result.getStatus());
        verify(missileRepository, times(1)).save(any(Missile.class));
    }

    // Test 2: SRP - Validation delegated, empty name throws exception
    @Test
    void shouldThrowExceptionWhenNameIsEmpty() {
        // SOLID: SRP - validation handled by MissileValidator
        assertThrows(IllegalArgumentException.class,
                () -> missileService.createMissile("", "CRUISE", 1000000.0, 5));
        verify(missileRepository, never()).save(any());
    }

    // Test 3: SRP - Validation delegated, null name throws exception
    @Test
    void shouldThrowExceptionWhenNameIsNull() {
        // SOLID: SRP - MissileValidator handles null checks
        assertThrows(IllegalArgumentException.class,
                () -> missileService.createMissile(null, "CRUISE", 1000000.0, 5));
        verify(missileRepository, never()).save(any());
    }

    // Test 4: Edge case - invalid price
    @Test
    void shouldThrowExceptionWhenPriceIsInvalid() {
        assertThrows(IllegalArgumentException.class,
                () -> missileService.createMissile("Tomahawk", "CRUISE", 0, 5));
    }

    // Test 5: Edge case - invalid quantity
    @Test
    void shouldThrowExceptionWhenQuantityIsInvalid() {
        assertThrows(IllegalArgumentException.class,
                () -> missileService.createMissile("Tomahawk", "CRUISE", 1000000.0, 0));
    }

    // Test 6: OCP + Polymorphism - Launch via air
    @Test
    void shouldLaunchMissileViaAir() {
        // SOLID: OCP - new launch types don't change this logic
        Missile mockMissile = new Missile("Tomahawk", "CRUISE", 1000000.0, 2);
        when(missileRepository.findById(1L)).thenReturn(Optional.of(mockMissile));
        when(missileRepository.save(any(Missile.class))).thenReturn(mockMissile);

        MissileDTO result = missileService.launchMissile(1L, "air");

        assertEquals("LAUNCHED", result.getStatus());
        verify(airLaunch, times(1)).execute(2000000.0);
    }

    // Test 7: OCP + Polymorphism - Launch via sea
    @Test
    void shouldLaunchMissileViaSea() {
        Missile mockMissile = new Missile("Patriot", "BALLISTIC", 500000.0, 3);
        when(missileRepository.findById(2L)).thenReturn(Optional.of(mockMissile));
        when(missileRepository.save(any(Missile.class))).thenReturn(mockMissile);

        MissileDTO result = missileService.launchMissile(2L, "sea");

        assertEquals("LAUNCHED", result.getStatus());
        verify(seaLaunch, times(1)).execute(1500000.0);
    }

    // Test 8: Edge case - already launched
    @Test
    void shouldThrowExceptionWhenMissileAlreadyLaunched() {
        Missile mockMissile = new Missile("Tomahawk", "CRUISE", 1000000.0, 1);
        mockMissile.setStatus("LAUNCHED");
        when(missileRepository.findById(1L)).thenReturn(Optional.of(mockMissile));

        assertThrows(IllegalStateException.class,
                () -> missileService.launchMissile(1L, "air"));
    }

    // Test 9: Edge case - missile not found
    @Test
    void shouldThrowExceptionWhenMissileNotFound() {
        when(missileRepository.findById(99L)).thenReturn(Optional.empty());

        assertThrows(IllegalArgumentException.class,
                () -> missileService.getMissile(99L));
    }

    // Test 10: Destroy missile successfully
    @Test
    void shouldDestroyMissileSuccessfully() {
        Missile mockMissile = new Missile("Tomahawk", "CRUISE", 1000000.0, 1);
        when(missileRepository.findById(1L)).thenReturn(Optional.of(mockMissile));
        when(missileRepository.save(any(Missile.class))).thenReturn(mockMissile);

        MissileDTO result = missileService.destroyMissile(1L);

        assertEquals("DESTROYED", result.getStatus());
    }

    // Test 11: Edge case - already destroyed
    @Test
    void shouldThrowExceptionWhenMissileAlreadyDestroyed() {
        Missile mockMissile = new Missile("Tomahawk", "CRUISE", 1000000.0, 1);
        mockMissile.setStatus("DESTROYED");
        when(missileRepository.findById(1L)).thenReturn(Optional.of(mockMissile));

        assertThrows(IllegalStateException.class,
                () -> missileService.destroyMissile(1L));
    }

    // Test 12: Information Expert - correct total calculation
    @Test
    void shouldCalculateMissileTotalCorrectly() {
        Missile mockMissile = new Missile("Tomahawk", "CRUISE", 1000000.0, 3);
        when(missileRepository.save(any(Missile.class))).thenReturn(mockMissile);

        MissileDTO result = missileService.createMissile("Tomahawk", "CRUISE", 1000000.0, 3);

        assertEquals(3000000.0, result.getTotal());
    }

    // Test 13: DIP - depends on interface, unknown launch type throws exception
    @Test
    void shouldThrowExceptionForUnknownLaunchType() {
        // SOLID: DIP - depends on LaunchMethod interface
        Missile mockMissile = new Missile("Tomahawk", "CRUISE", 1000000.0, 1);
        when(missileRepository.findById(1L)).thenReturn(Optional.of(mockMissile));

        assertThrows(IllegalArgumentException.class,
                () -> missileService.launchMissile(1L, "nuclear"));
    }

    // Test 14: Edge case - get all missiles empty list
    @Test
    void shouldReturnEmptyListWhenNoMissiles() {
        when(missileRepository.findAll()).thenReturn(new ArrayList<>());

        List<MissileDTO> result = missileService.getAllMissiles();

        assertNotNull(result);
        assertEquals(0, result.size());
    }
}