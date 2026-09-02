package com.fcolucasvieira.desafio_estagio_java.mapper;

import com.fcolucasvieira.desafio_estagio_java.domain.Task;
import com.fcolucasvieira.desafio_estagio_java.dto.CreateTaskRequest;
import com.fcolucasvieira.desafio_estagio_java.dto.TaskResponse;
import org.springframework.stereotype.Component;

@Component
public class TaskMapper {
    public Task toEntity(CreateTaskRequest request) {
        return new Task(
                request.title(),
                request.description(),
                request.responsible(),
                request.deliveryDate()
        );
    }

    public TaskResponse toResponse(Task task) {
        return new TaskResponse(
                task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.getResponsible(),
                task.getDeliveryDate(),
                task.isCompleted()
        );
    }
}
