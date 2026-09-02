package com.fcolucasvieira.desafio_estagio_java.repository;

import com.fcolucasvieira.desafio_estagio_java.domain.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface TaskRepository extends JpaRepository<Task, UUID> {
    Optional<Task> findById(UUID id);

    List<Task> findByResponsibleContainingIgnoreCase(String responsible);

    List<Task> findByDeliveryDate(LocalDate deliveryDate);

    List<Task> findByCompletedFalse();

    List<Task> findByCompletedFalseAndResponsibleContainingIgnoreCase(String responsible);
}
