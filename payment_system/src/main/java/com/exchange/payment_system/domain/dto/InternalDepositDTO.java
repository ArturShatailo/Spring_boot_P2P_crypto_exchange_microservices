package com.exchange.payment_system.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InternalDepositDTO {

    public String email;

    public Double amount;

    public String from_account_wallet;

    public String to_digital_wallet;

    private Long crypto_currency_id;

}
