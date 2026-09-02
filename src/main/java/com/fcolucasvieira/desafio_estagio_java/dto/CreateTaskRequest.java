package com.fcolucasvieira.desafio_estagio_java.dto;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public record CreateTaskRequest (
        String title,
        String description,
        String responsible,
        LocalDateTime deliveryDate) {
}
