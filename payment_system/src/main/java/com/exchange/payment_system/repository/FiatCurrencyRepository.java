package com.exchange.payment_system.repository;

import com.exchange.payment_system.domain.FiatCurrency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FiatCurrencyRepository extends JpaRepository<FiatCurrency, Long> {
}
