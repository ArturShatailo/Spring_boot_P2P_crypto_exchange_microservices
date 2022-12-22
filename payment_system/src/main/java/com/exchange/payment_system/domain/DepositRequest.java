package com.exchange.payment_system.domain;

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

    @OneToOne(cascade = CascadeType.ALL)
    private Currency currency;

    private String status;

}
