package com.exchange.payment_system.repository;

import com.exchange.payment_system.domain.transactions.InternalDeposit;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface InternalDepositRepository extends JpaRepository<InternalDeposit, Long> {

    Optional<InternalDeposit> findInternalDepositByIdAndStatus(Long id, String status);

}
