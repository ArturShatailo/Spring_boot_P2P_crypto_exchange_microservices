package com.exchange.payment_methods_management.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CardDetailsDTO {

    public String number;

    public String name;

    public String surname;

    public PaymentMethodDTO paymentMethod;

    public BankDTO bankIssuer;

    public String clientEmail;

}
