package com.exchange.payment_system.domain.transactions;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "withdrawal_requests")
@AllArgsConstructor
@NoArgsConstructor
public class WithdrawalRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    private Double amount;

    private String wallet;

    private String status = "NEW";

}
