package com.exchange.payment_system.domain.transactions;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Entity
@Table(name = "internal_withdrawals")
@AllArgsConstructor
@NoArgsConstructor
public class InternalWithdrawal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

//    @ManyToOne(cascade = CascadeType.ALL)
//    private DigitalWallet from;
//
//    @ManyToOne(cascade = CascadeType.ALL)
//    private AccountWallet to;

    private String from_digital_wallet;

    private String to_account_wallet;

    private Double amount;

    private Date timestamp = new Date();

    private String status = "NEW";

    private Long currency_id;

}
