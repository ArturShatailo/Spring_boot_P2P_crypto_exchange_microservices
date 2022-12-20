package com.exchange.clients_management.util.exceptions;

import java.util.Date;

public record ExceptionDetails(Date timestamp, String message, String details) {
}