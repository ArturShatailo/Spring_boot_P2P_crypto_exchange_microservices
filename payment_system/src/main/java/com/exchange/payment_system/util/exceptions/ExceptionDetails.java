package com.exchange.payment_system.util.exceptions;

import java.util.Date;

public record ExceptionDetails(Date timestamp, String message, String details) {
}