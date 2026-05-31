package com.trespeces.demo.app.service;

import com.trespeces.demo.app.dto.MissileDTO;
import com.trespeces.demo.app.entity.Missile;
import com.trespeces.demo.app.repository.MissileRepository;
import com.trespeces.demo.app.util.LaunchMethod;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

// GRASP: Pure Fabrication - Service exists for business logic only
// GRASP: High Cohesion - only handles Missile business logic
// GRASP: Low Coupling - depends on interfaces, not implementations
@Service
@RequiredArgsConstructor
public class MissileService {

    private final MissileRepository missileRepository;
    private final Map<String, LaunchMethod> launchMethodMap;

    // GRASP: Creator - Service creates Missile objects
    public MissileDTO createMissile(String name, String type, double price, int quantity) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Missile name cannot be empty");
        }
        if (price <= 0 || quantity <= 0) {
            throw new IllegalArgumentException("Price and quantity must be greater than zero");
        }

        Missile missile = new Missile(name, type, price, quantity);
        Missile saved = missileRepository.save(missile);
        return toDTO(saved);
    }

    public MissileDTO getMissile(Long id) {
        Optional<Missile> result = missileRepository.findById(id);
        if (result.isEmpty()) {
            throw new IllegalArgumentException("Missile not found: " + id);
        }
        return toDTO(result.get());
    }

    public List<MissileDTO> getAllMissiles() {
        List<Missile> missiles = missileRepository.findAll();
        List<MissileDTO> dtos = new ArrayList<>();
        for (Missile m : missiles) {
            dtos.add(toDTO(m));
        }
        return dtos;
    }

    // GRASP: Polymorphism - uses LaunchMethod interface, works for any launch type
    // GRASP: Protected Variations - adding new launch type won't break this
    public MissileDTO launchMissile(Long id, String launchType) {
        Optional<Missile> result = missileRepository.findById(id);
        if (result.isEmpty()) {
            throw new IllegalArgumentException("Missile not found: " + id);
        }

        Missile missile = result.get();

        if ("LAUNCHED".equals(missile.getStatus())) {
            throw new IllegalStateException("Missile already launched");
        }
        if ("DESTROYED".equals(missile.getStatus())) {
            throw new IllegalStateException("Missile is already destroyed");
        }

        LaunchMethod method = launchMethodMap.get(launchType.toLowerCase() + "Launch");
        if (method == null) {
            throw new IllegalArgumentException("Unknown launch type: " + launchType);
        }

        // GRASP: Information Expert - missile calculates its own total
        method.execute(missile.calculateTotal());
        missile.setStatus("LAUNCHED");

        return toDTO(missileRepository.save(missile));
    }

    public MissileDTO destroyMissile(Long id) {
        Optional<Missile> result = missileRepository.findById(id);
        if (result.isEmpty()) {
            throw new IllegalArgumentException("Missile not found: " + id);
        }

        Missile missile = result.get();

        if ("DESTROYED".equals(missile.getStatus())) {
            throw new IllegalStateException("Missile is already destroyed");
        }

        missile.setStatus("DESTROYED");
        return toDTO(missileRepository.save(missile));
    }

    // GRASP: Pure Fabrication - helper to convert entity to DTO
    private MissileDTO toDTO(Missile missile) {
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