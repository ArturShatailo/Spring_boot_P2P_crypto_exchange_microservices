package com.exchange.clients_management.util.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ClientNotFoundException.class)
    protected ResponseEntity<?> handleClientNotFoundException(ClientNotFoundException ex, WebRequest request) {
        ExceptionDetails errorDetails =
                new ExceptionDetails(new Date(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(EmailRegisteredException.class)
    protected ResponseEntity<?> handleEmailRegisteredException(EmailRegisteredException ex, WebRequest request) {
        ExceptionDetails errorDetails =
                new ExceptionDetails(new Date(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<MyGlobalExceptionHandler> globalExceptionHandler(Exception ex) {
        return new ResponseEntity<>(new MyGlobalExceptionHandler(ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Data
    @AllArgsConstructor
    private static class MyGlobalExceptionHandler {
        private String message;
    }
}
