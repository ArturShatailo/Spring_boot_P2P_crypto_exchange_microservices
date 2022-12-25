package com.exchange.payment_system.domain.transactions;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@Entity
@Table(name = "internal_deposits")
@AllArgsConstructor
@NoArgsConstructor
public class InternalDeposit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

//    @ManyToOne(cascade = CascadeType.ALL)
//    private AccountWallet from;
//
//    @ManyToOne(cascade = CascadeType.ALL)
//    private DigitalWallet to;

    private String from_account_wallet;

    private String to_digital_wallet;

    private Double amount;

    private Date timestamp = new Date();

    private String status = "NEW";

    private Long currency_id;

}
