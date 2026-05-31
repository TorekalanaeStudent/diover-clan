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
// SOLID: SRP - Service handles business logic only
// SOLID: DIP - Depends on abstractions (MissileRepository, LaunchMethod interfaces)
@Service
@RequiredArgsConstructor
public class MissileService {

    private final MissileRepository missileRepository;
    private final Map<String, LaunchMethod> launchMethodMap;

    // SOLID: SRP - each helper has its own responsibility
    // DRY: Centralized validation and mapping
    private final MissileValidator missileValidator = new MissileValidator();
    private final MissileMapper missileMapper = new MissileMapper();

    // GRASP: Creator - Service creates Missile objects
    // SOLID: SRP - createMissile only handles creation, not validation
    public MissileDTO createMissile(String name, String type, double price, int quantity) {
        // DRY: Reusing centralized validation
        missileValidator.validate(name, price, quantity);

        Missile missile = new Missile(name, type, price, quantity);
        Missile saved = missileRepository.save(missile);
        return missileMapper.toDTO(saved);
    }

    public MissileDTO getMissile(Long id) {
        Optional<Missile> result = missileRepository.findById(id);
        if (result.isEmpty()) {
            throw new IllegalArgumentException("Missile not found: " + id);
        }
        return missileMapper.toDTO(result.get());
    }

    public List<MissileDTO> getAllMissiles() {
        List<Missile> missiles = missileRepository.findAll();
        List<MissileDTO> dtos = new ArrayList<>();
        for (Missile m : missiles) {
            dtos.add(missileMapper.toDTO(m));
        }
        return dtos;
    }

    // GRASP: Polymorphism - uses LaunchMethod interface
    // SOLID: OCP - open for extension, closed for modification
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

        method.execute(missile.calculateTotal());
        missile.setStatus("LAUNCHED");

        return missileMapper.toDTO(missileRepository.save(missile));
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
        return missileMapper.toDTO(missileRepository.save(missile));
    }
}