package com.exchange.payment_system.util.exceptions;

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

    @ExceptionHandler(AccountWalletNotFoundException.class)
    protected ResponseEntity<?> handleAccountWalletNotFoundException(AccountWalletNotFoundException ex, WebRequest request) {
        ExceptionDetails errorDetails =
                new ExceptionDetails(new Date(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(DigitalWalletNotFoundException.class)
    protected ResponseEntity<?> handleDigitalWalletNotFoundException(DigitalWalletNotFoundException ex, WebRequest request) {
        ExceptionDetails errorDetails =
                new ExceptionDetails(new Date(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(DepositRequestNotFoundException.class)
    protected ResponseEntity<?> handleDepositRequestNotFoundException(DepositRequestNotFoundException ex, WebRequest request) {
        ExceptionDetails errorDetails =
                new ExceptionDetails(new Date(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(CurrencyNotFoundException.class)
    protected ResponseEntity<?> handleCurrencyNotFoundException(CurrencyNotFoundException ex, WebRequest request) {
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