package com.exchange.payment_system.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Entity
@Table(name = "internal_transactions")
@AllArgsConstructor
@NoArgsConstructor
public class InternalTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    private String from_id;

    private String to_id;

    private Double amount;

    private String currency;

    private Date timestamp = new Date();

    private String status;

}
