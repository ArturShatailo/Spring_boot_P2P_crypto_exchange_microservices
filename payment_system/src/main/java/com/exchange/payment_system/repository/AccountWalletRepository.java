package com.exchange.payment_system.repository;

import com.exchange.payment_system.domain.wallets.AccountWallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountWalletRepository extends JpaRepository<AccountWallet, Long> {

    Optional<AccountWallet> findAccountWalletByEmailAndCryptoCurrencyId (String email, Long id);

    Optional<AccountWallet> findAccountWalletByEmailAndNumber (String email, String number);

}
