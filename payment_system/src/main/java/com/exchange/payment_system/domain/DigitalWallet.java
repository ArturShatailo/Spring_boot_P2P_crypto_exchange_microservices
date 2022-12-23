package com.exchange.payment_system.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "digital_wallets")
@AllArgsConstructor
@NoArgsConstructor
public class DigitalWallet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String number;

    private String email;

    private Double balance;

    @OneToOne(cascade = CascadeType.ALL)
    private Currency currency;

    private Double balance_held;

    private Double balance_available;

    public void calculateAvailableBalance(){
        balance_available = balance - balance_held;
    }

}
