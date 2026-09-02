package com.fcolucasvieira.desafio_estagio_java.service;

import com.fcolucasvieira.desafio_estagio_java.domain.Task;
import com.fcolucasvieira.desafio_estagio_java.dto.CreateTaskRequest;
import com.fcolucasvieira.desafio_estagio_java.exception.TaskNotFoundException;
import com.fcolucasvieira.desafio_estagio_java.mapper.TaskMapper;
import com.fcolucasvieira.desafio_estagio_java.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TaskService {
    private final TaskRepository repository;
    private final TaskMapper mapper;

    public Task create(CreateTaskRequest request) {
        Task task = mapper.toEntity(request);

        return repository.save(task);
    }

    public Task findById(UUID id) {
        return repository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException("Task not found with Id: " + id));
    }
}
