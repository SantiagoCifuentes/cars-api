package com.santiago.cars.controller;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    /**
        * Maneja excepciones de entidad no encontrada.
     * Los tres métodos se tuvieron que cambiar a utilizarse con un hashmap ya que en los tests
     * no reconocía el uso de Map.of()
     */
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<?> handleNotFound(EntityNotFoundException ex) {
        Map<String, Object> body = new java.util.HashMap<>();
        body.put("data", null);
        body.put("status", 404);
        body.put("message", ex.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(body);
    }

    /**
        * Maneja errores de validación de argumentos.
     */

    public ResponseEntity<?> handleValidationErrors(MethodArgumentNotValidException ex) {
        List<String> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(err -> {
                    String field = err.getField() != null ? err.getField() : "unknown";
                    String msg = err.getDefaultMessage() != null ? err.getDefaultMessage() : "error";
                    return field + ": " + msg;
                })
                .toList();

        Map<String, Object> body = new java.util.HashMap<>();
        body.put("data", null);
        body.put("status", 400);
        body.put("message", "Errores de validación");
        body.put("errors", errors);

        return ResponseEntity.badRequest().body(body);
    }

    /**
     * Maneja errores generales no capturados.
     */

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleGeneralErrors(Exception ex) {
        Map<String, Object> body = new java.util.HashMap<>();
        body.put("data", null);
        body.put("status", 500);
        body.put("message", "Error interno"+ ex.getMessage());

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(body);
    }
}

