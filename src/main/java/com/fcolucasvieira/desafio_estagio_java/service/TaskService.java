package com.fcolucasvieira.desafio_estagio_java.service;

import com.fcolucasvieira.desafio_estagio_java.repository.TaskRepository;

public class TaskService {
    private final TaskRepository repository;

    public TaskService(TaskRepository repository) {
        this.repository = repository;
    }
}
