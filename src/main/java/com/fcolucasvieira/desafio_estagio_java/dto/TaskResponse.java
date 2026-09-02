package com.fcolucasvieira.desafio_estagio_java.dto;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.UUID;

public record TaskResponse (
        UUID id,
        String title,
        String description,
        String responsible,
        LocalDateTime deliveryDate,
        boolean completed
)
{}
