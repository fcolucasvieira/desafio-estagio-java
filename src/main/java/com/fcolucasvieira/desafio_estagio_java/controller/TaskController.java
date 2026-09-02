package com.fcolucasvieira.desafio_estagio_java.controller;

import com.fcolucasvieira.desafio_estagio_java.domain.Task;
import com.fcolucasvieira.desafio_estagio_java.dto.CreateTaskRequest;
import com.fcolucasvieira.desafio_estagio_java.dto.TaskResponse;
import com.fcolucasvieira.desafio_estagio_java.mapper.TaskMapper;
import com.fcolucasvieira.desafio_estagio_java.repository.TaskRepository;
import com.fcolucasvieira.desafio_estagio_java.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/tasks")
@RequiredArgsConstructor
public class TaskController
{
    private final TaskRepository repository;
    private final TaskService service;
    private final TaskMapper mapper;

    @PostMapping
    public ResponseEntity<TaskResponse> create(@RequestBody CreateTaskRequest request) {
        Task task = service.create(request);

        TaskResponse response = mapper.toResponse(task);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskResponse> findById(@PathVariable UUID id) {
        Task task = service.findById(id);

        TaskResponse response = mapper.toResponse(task);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
