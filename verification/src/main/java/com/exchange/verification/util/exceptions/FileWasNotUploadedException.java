package com.exchange.verification.util.exceptions;

public class FileWasNotUploadedException extends RuntimeException{
    public FileWasNotUploadedException(String message) {
        super(message);
    }
}
