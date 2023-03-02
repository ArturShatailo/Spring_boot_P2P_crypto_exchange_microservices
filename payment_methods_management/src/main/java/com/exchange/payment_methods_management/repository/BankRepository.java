package com.exchange.payment_methods_management.repository;

import com.exchange.payment_methods_management.domain.Bank;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankRepository extends JpaRepository<Bank, Long> {
}
