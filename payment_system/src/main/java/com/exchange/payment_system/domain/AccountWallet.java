package com.exchange.payment_system.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "account_wallets")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AccountWallet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String number;

    private String email;

    private Double balance;

    @ManyToOne(cascade = CascadeType.ALL)
    private Currency currency;

    public void increaseBalance(Double amount) {
        balance += amount;
    }

    public void decreaseBalance(Double amount) {
        balance -= amount;
    }


}
