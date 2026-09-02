package com.fcolucasvieira.desafio_estagio_java.controller;

import com.fcolucasvieira.desafio_estagio_java.domain.Task;
import com.fcolucasvieira.desafio_estagio_java.dto.CreateTaskRequest;
import com.fcolucasvieira.desafio_estagio_java.dto.TaskResponse;
import com.fcolucasvieira.desafio_estagio_java.mapper.TaskMapper;
import com.fcolucasvieira.desafio_estagio_java.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/tasks")
@RequiredArgsConstructor
public class TaskController {
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

    @GetMapping("/responsible")
    public ResponseEntity<List<TaskResponse>> findByResponsible(@RequestParam(name = "responsible") String responsible) {
        List<Task> tasks = service.findByResponsible(responsible);

        List<TaskResponse> response = mapper.toListResponse(tasks);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/deliveryDate")
    public ResponseEntity<List<TaskResponse>> findByDeliveryDate(@RequestParam(name = "deliveryDate") LocalDate deliveryDate) {
        List<Task> tasks = service.findByDeliveryDate(deliveryDate);

        List<TaskResponse> response = mapper.toListResponse(tasks);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/incomplete")
    public ResponseEntity<List<TaskResponse>> incomplete() {
        List<Task> tasks = service.findByCompletedFalse();

        List<TaskResponse> response = mapper.toListResponse(tasks);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/incomplete-by-responsible")
    public ResponseEntity<List<TaskResponse>> incompleteByResponsible(@RequestParam(name = "responsible") String responsible) {
        List<Task> tasks = service.findByCompletedFalseAndResponsible(responsible);

        List<TaskResponse> response = mapper.toListResponse(tasks);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
