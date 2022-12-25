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

    @ExceptionHandler(P2PTransactionNotFoundException.class)
    protected ResponseEntity<?> handleP2PTransactionNotFoundException(P2PTransactionNotFoundException ex, WebRequest request) {
        ExceptionDetails errorDetails =
                new ExceptionDetails(new Date(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(CurrenciesAreNotEqualsException.class)
    protected ResponseEntity<?> handleCurrenciesAreNotEqualsException(CurrenciesAreNotEqualsException ex, WebRequest request) {
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

    @ExceptionHandler(NotEnoughFundsOnBalanceException.class)
    protected ResponseEntity<?> handleNotEnoughFundsOnBalanceException(NotEnoughFundsOnBalanceException ex, WebRequest request) {
        ExceptionDetails errorDetails =
                new ExceptionDetails(new Date(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ClientIsNotVerifiedException.class)
    protected ResponseEntity<?> handleClientIsNotVerifiedException(ClientIsNotVerifiedException ex, WebRequest request) {
        ExceptionDetails errorDetails =
                new ExceptionDetails(new Date(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InternalDepositRequestNotFoundException.class)
    protected ResponseEntity<?> handleInternalDepositRequestNotFoundException(InternalDepositRequestNotFoundException ex, WebRequest request) {
        ExceptionDetails errorDetails =
                new ExceptionDetails(new Date(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InternalWithdrawalRequestNotFoundException.class)
    protected ResponseEntity<?> handleInternalWithdrawalRequestNotFoundException(InternalWithdrawalRequestNotFoundException ex, WebRequest request) {
        ExceptionDetails errorDetails =
                new ExceptionDetails(new Date(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(AccountWalletExistsException.class)
    protected ResponseEntity<?> handleAccountWalletExistsException(AccountWalletExistsException ex, WebRequest request) {
        ExceptionDetails errorDetails =
                new ExceptionDetails(new Date(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(WithdrawalRequestNotFoundException.class)
    protected ResponseEntity<?> handleWithdrawalRequestNotFoundException(WithdrawalRequestNotFoundException ex, WebRequest request) {
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
