package com.santiago.cars.controller;

import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class GlobalExceptionHandlerTest {

    private final GlobalExceptionHandler handler = new GlobalExceptionHandler();

    @Test
    void testHandleNotFound() {
        EntityNotFoundException ex = new EntityNotFoundException("No encontrado");
        ResponseEntity<?> response = handler.handleNotFound(ex);
        assertEquals(404, response.getStatusCodeValue());
        assertTrue(response.getBody().toString().contains("No encontrado"));
    }

    @Test
    void testHandleValidationErrors() {
        BindingResult bindingResult = mock(BindingResult.class);
        FieldError fieldError = new FieldError("obj", "campo", "es requerido");
        when(bindingResult.getFieldErrors()).thenReturn(List.of(fieldError));
        MethodArgumentNotValidException ex = new MethodArgumentNotValidException(null, bindingResult);

        ResponseEntity<?> response = handler.handleValidationErrors(ex);
        assertEquals(400, response.getStatusCodeValue());
        assertTrue(response.getBody().toString().contains("Errores de validación"));
        assertTrue(response.getBody().toString().contains("campo: es requerido"));
    }

    @Test
    void testHandleGeneralErrors() {
        Exception ex = new Exception("Error genérico");
        ResponseEntity<?> response = handler.handleGeneralErrors(ex);
        assertEquals(500, response.getStatusCodeValue());
        assertTrue(response.getBody().toString().contains("Error interno"));
    }
}
