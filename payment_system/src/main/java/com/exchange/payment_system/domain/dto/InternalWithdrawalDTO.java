package com.exchange.payment_system.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InternalWithdrawalDTO {

    public String email;

    public Double amount;

    public String from_digital_wallet;

    public String to_account_wallet;

    private Long crypto_currency_id;

}
