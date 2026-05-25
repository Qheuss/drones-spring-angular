package com.drones.back.controllers;

import com.drones.back.exceptions.NotFoundException;
import com.drones.back.exceptions.ValidationException;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

  @ExceptionHandler(NotFoundException.class)
  public ResponseEntity<ErrorResponse> handleNotFound(NotFoundException ex) {
    log.warn("NotFound: {}", ex.getMessage());
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
      new ErrorResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage())
    );
  }

  @ExceptionHandler(ValidationException.class)
  public ResponseEntity<ErrorResponse> handleValidation(
    ValidationException ex
  ) {
    log.warn("Validation failed: {}", ex.getMessage());
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
      new ErrorResponse(HttpStatus.BAD_REQUEST.value(), ex.getMessage())
    );
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<ErrorResponse> handleGeneric(Exception ex) {
    log.error("Unhandled error: ", ex);
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
      new ErrorResponse(
        HttpStatus.INTERNAL_SERVER_ERROR.value(),
        "Internal server error"
      )
    );
  }

  @Data
  static class ErrorResponse {

    private final int status;
    private final String message;
  }
}
