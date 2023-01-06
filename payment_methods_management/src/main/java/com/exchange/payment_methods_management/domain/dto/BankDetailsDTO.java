package com.exchange.payment_methods_management.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BankDetailsDTO {

    public String iban;

    public String name;

    public String surname;

    public PaymentMethodDTO paymentMethod;

    public BankDTO bank;

    public String clientEmail;

}
