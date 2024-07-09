package com.alura.forohub.exceptions;

import com.alura.forohub.exceptions.TopicoNoEncontradoException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(TopicoNoEncontradoException.class)
    public ResponseEntity<Object> handleTopicoNoEncontradoException(TopicoNoEncontradoException ex) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        return ResponseEntity.status(status).body(ex.getMessage());
    }

    @ExceptionHandler(UsuarioNoEncontradoExcepcion.class)
    public ResponseEntity<Object> handleUsuarioNoEncontradoExcepcion(UsuarioNoEncontradoExcepcion ex) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        return ResponseEntity.status(status).body(ex.getMessage());
    }

}
