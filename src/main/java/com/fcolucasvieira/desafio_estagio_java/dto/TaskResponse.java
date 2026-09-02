package com.fcolucasvieira.desafio_estagio_java.dto;

import java.time.LocalDate;
import java.util.UUID;

public record TaskResponse (
        UUID id,
        String title,
        String description,
        String responsible,
        LocalDate deliveryDate,
        boolean completed
)
{}
