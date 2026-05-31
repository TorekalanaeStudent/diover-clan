package com.go.service;

import com.go.entity.BackendEntity;
import com.go.repository.BackendRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BackendService {

    private final BackendRepository repository;

    public BackendService(BackendRepository repository) {
        this.repository = repository;
    }

    /* -------------------- GET ALL -------------------- */
    public List<BackendEntity> getAll() {
        return repository.findAll();
    }

    /* -------------------- CREATE -------------------- */
    public BackendEntity add(BackendEntity entity) {
        return repository.save(entity);
    }

    /* -------------------- SIGNUP -------------------- */
    public BackendEntity signup(BackendEntity entity) {
        return repository.save(entity);
    }

    /* -------------------- LOGIN -------------------- */
    public BackendEntity login(String email, String password) {
        return repository.findAll().stream()
                .filter(emp ->
                        emp.getEmployeeEmail().equals(email) &&
                                emp.getEmployeePassword().equals(password)
                )
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Invalid credentials"));
    }

    /* -------------------- GET BY ID -------------------- */
    public BackendEntity getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Not found"));
    }

    /* -------------------- DELETE -------------------- */
    public void delete(Long id) {
        repository.deleteById(id);
    }
}