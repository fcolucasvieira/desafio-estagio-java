package com.fcolucasvieira.desafio_estagio_java.dto;

import java.sql.Timestamp;

public record CreateTaskRequest (
        String title,
        String description,
        String responsible,
        Timestamp deliveryDate) {
}
