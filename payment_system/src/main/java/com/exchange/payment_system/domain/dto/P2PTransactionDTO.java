package com.exchange.payment_system.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class P2PTransactionDTO {

    private String email_from;

    private String email_to;

    private String from_wallet;

    private String to_wallet;

    private Double amount;

    private Long currency_id;

}
