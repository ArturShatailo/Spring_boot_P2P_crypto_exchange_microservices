package com.exchange.payment_system.domain.wallets;

import com.exchange.payment_system.domain.CryptoCurrency;
import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "digital_wallets")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DigitalWallet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String number;

    private String email;

    private Double balance;

    @ManyToOne(cascade = CascadeType.ALL)
    private CryptoCurrency cryptoCurrency;

    private Double balance_held;

    private Double balance_available;

    public void calculateAvailableBalance(){
        balance_available = balance - balance_held;
    }

    @Transactional
    public void increaseBalance(Double amount) {
        balance += amount;
        calculateAvailableBalance();
    }

    @Transactional
    public void decreaseBalance(Double amount) {
        balance -= amount;
        calculateAvailableBalance();
    }

    @Transactional
    public void p2pTransferBalance(Double amount) {
        balance -= amount;
        balance_held -= amount;
        calculateAvailableBalance();
    }

    @Transactional
    public void holdBalance(Double amount) {
        balance_held += amount;
        calculateAvailableBalance();
    }


}
