package com.cardeno.a.service;

import com.cardeno.a.model.Task;
import com.cardeno.a.repository.TaskRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TaskService {
    private final TaskRepository repo;
    public TaskService(TaskRepository repo) {
        this.repo = repo;
    }

    public List<Task> getAll() {
        return repo.findAll();
    }
    public Task create(Task task) {
        return repo.save(task);
    }
    public Task update(Long id, Task task) {
        Task t = repo.findById(id).orElseThrow();
        t.setTitle(task.getTitle());
        return repo.save(t);
    }
    public void delete(Long id) {
        repo.deleteById(id);
    }
}