package com.exchange.payment_system.domain.transactions;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "deposit_requests")
@AllArgsConstructor
@NoArgsConstructor
public class DepositRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    private Double amount;

    private String wallet;

    private Long crypto_currency_id;

    private String status = "NEW";

}
