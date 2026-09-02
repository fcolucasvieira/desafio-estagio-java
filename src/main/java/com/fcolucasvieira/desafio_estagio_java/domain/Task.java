package com.fcolucasvieira.desafio_estagio_java.domain;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "tasks")
@Getter
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String title;
    private String description;
    private String responsible;

    @Column(name = "delivery_date")
    private LocalDate deliveryDate;

    private boolean completed;

    public Task(String title, String description, String responsible, LocalDate deliveryDate) {
        this.title = title;
        this.description = description;
        this.responsible = responsible;
        this.deliveryDate = deliveryDate;
        this.completed = false;
    }

    protected Task() {}
}
