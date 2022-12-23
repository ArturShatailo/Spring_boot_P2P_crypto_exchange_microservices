package com.exchange.payment_system.domain.transactions;

import com.exchange.payment_system.domain.AccountWallet;
import com.exchange.payment_system.domain.Currency;
import com.exchange.payment_system.domain.DigitalWallet;
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

    @ManyToOne(cascade = CascadeType.ALL)
    private AccountWallet from;

    @ManyToOne(cascade = CascadeType.ALL)
    private DigitalWallet to;

    private Double amount;

    @OneToOne(cascade = CascadeType.ALL)
    private Currency currency;

    private Date timestamp = new Date();

    private String status;

}
