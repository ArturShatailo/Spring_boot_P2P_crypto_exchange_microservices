package com.exchange.payment_system.repository;

import com.exchange.payment_system.domain.DigitalWallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DigitalWalletRepository extends JpaRepository<DigitalWallet, Long> {

    Optional<DigitalWallet> findDigitalWalletByEmailAndNumber (String email, String number);

}
