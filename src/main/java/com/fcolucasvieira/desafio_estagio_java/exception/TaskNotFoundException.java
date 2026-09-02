package com.fcolucasvieira.desafio_estagio_java.exception;

import org.springframework.http.HttpStatus;

public class TaskNotFoundException extends BusinessException {
    public TaskNotFoundException(String message) {
        super(message, HttpStatus.NOT_FOUND);
    }
}
