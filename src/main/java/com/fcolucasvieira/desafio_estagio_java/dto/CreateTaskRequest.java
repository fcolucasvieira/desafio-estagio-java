package com.fcolucasvieira.desafio_estagio_java.dto;

import java.time.LocalDate;

public record CreateTaskRequest (
        String title,
        String description,
        String responsible,
        LocalDate deliveryDate) {
}
