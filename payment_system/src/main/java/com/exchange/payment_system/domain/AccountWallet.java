package com.exchange.payment_system.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "account_wallets")
@AllArgsConstructor
@NoArgsConstructor
public class AccountWallet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String identification_number;

    private String email;

    private Double balance;

    @OneToOne(cascade = CascadeType.ALL)
    private Currency currency;

}
