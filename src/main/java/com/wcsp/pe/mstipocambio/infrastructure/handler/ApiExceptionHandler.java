package com.wcsp.pe.mstipocambio.infrastructure.handler;

import com.wcsp.pe.mstipocambio.domain.dto.response.CustomResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingRequestHeaderException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ApiExceptionHandler {

  @ResponseStatus(HttpStatus.FORBIDDEN)
  @ExceptionHandler(MissingRequestHeaderException.class)
  public ResponseEntity<CustomResponse> handleInvalidArgument(MissingRequestHeaderException ex) {
    return ResponseEntity.status(HttpStatus.FORBIDDEN).body(CustomResponse.builder()
            .estado(HttpStatus.FORBIDDEN.value())
            .datos("Falta el encabezado de autorización.")
            .build());
  }

  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<CustomResponse> handleInvalidArgument(MethodArgumentNotValidException ex) {
    Map<String, String> errors = new HashMap<>();
    ex.getFieldErrors().forEach(fieldError -> {
      errors.put(fieldError.getField(), fieldError.getDefaultMessage());
    });

    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(CustomResponse.builder()
            .estado(HttpStatus.BAD_REQUEST.value())
            .mensaje("Error de validación.")
            .errores(errors)
            .build());
  }

}
