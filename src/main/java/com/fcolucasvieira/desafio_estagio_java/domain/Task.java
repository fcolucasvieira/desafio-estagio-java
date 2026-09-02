package com.fcolucasvieira.desafio_estagio_java.domain;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.UUID;

@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String title;
    private String description;
    private String responsible;

    @Column(name = "delivery_date")
    private Timestamp deliveryDate;

    private boolean completed;

    public Task(String title, String description, String responsible, Timestamp deliveryDate) {
        this.title = title;
        this.description = description;
        this.responsible = responsible;
        this.deliveryDate = deliveryDate;
        this.completed = false;
    }
}
