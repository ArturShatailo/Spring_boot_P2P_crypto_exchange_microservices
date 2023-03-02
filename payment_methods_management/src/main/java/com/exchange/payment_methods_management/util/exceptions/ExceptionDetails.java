package com.exchange.payment_methods_management.util.exceptions;

import java.util.Date;

public record ExceptionDetails(Date timestamp, String message, String details) {
}