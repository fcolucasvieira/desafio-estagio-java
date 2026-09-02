package com.fcolucasvieira.desafio_estagio_java.repository;

import com.fcolucasvieira.desafio_estagio_java.domain.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface TaskRepository extends JpaRepository<Task, UUID> {
    Optional<Task> findById(UUID id);
}
