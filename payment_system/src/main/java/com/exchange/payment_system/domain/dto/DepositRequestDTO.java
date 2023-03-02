package com.exchange.payment_system.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepositRequestDTO {

    public String email;

    public Double amount;

    public String wallet;

    public Long crypto_currency_id;

}
