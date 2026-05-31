package com.go.controller;

import com.go.entity.BackendEntity;
import com.go.service.BackendService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
@CrossOrigin(origins = "http://localhost:5173", allowedHeaders = "*")
public class BackendController {

    private final BackendService service;

    public BackendController(BackendService service) {
        this.service = service;
    }

    @GetMapping
    public List<BackendEntity> getAll() {
        return service.getAll();
    }

    @PostMapping
    public BackendEntity add(@RequestBody BackendEntity entity) {
        return service.add(entity);
    }

    @PutMapping("/{id}")
    public BackendEntity update(@PathVariable Long id, @RequestBody BackendEntity updated) {
        BackendEntity existing = service.getById(id);

        existing.setEmployeeName(updated.getEmployeeName());
        existing.setEmployeeEmail(updated.getEmployeeEmail());
        existing.setEmployeePassword(updated.getEmployeePassword());
        existing.setEmployeePosition(updated.getEmployeePosition());
        existing.setCurrentlyInShift(updated.getCurrentlyInShift());

        return service.add(existing);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @PostMapping("/signup")
    public BackendEntity signup(@RequestBody BackendEntity entity) {
        return service.signup(entity);
    }

    @PostMapping("/login")
    public BackendEntity login(@RequestBody BackendEntity data) {
        return service.login(
                data.getEmployeeEmail(),
                data.getEmployeePassword()
        );
    }
}