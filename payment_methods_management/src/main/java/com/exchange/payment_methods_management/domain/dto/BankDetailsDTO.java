package com.exchange.payment_methods_management.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BankDetailsDTO {

    private String iban;

    private String name;

    private String surname;

    public PaymentMethodDTO paymentMethod;

    public BankDTO bank;

    private String clientEmail;

}
