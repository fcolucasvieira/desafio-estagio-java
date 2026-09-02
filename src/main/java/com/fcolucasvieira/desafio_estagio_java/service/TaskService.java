package com.fcolucasvieira.desafio_estagio_java.service;

import com.fcolucasvieira.desafio_estagio_java.domain.Task;
import com.fcolucasvieira.desafio_estagio_java.dto.CreateTaskRequest;
import com.fcolucasvieira.desafio_estagio_java.repository.TaskRepository;

import java.util.UUID;

public class TaskService {
    private final TaskRepository repository;

    public TaskService(TaskRepository repository) {
        this.repository = repository;
    }

    public Task create(CreateTaskRequest request) {
        Task task = new Task(
                request.title(),
                request.description(),
                request.responsible(),
                request.deliveryDate()
        );

        return repository.save(task);
    }

    public Task findById(UUID id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found with Id: " + id));
    }
}
