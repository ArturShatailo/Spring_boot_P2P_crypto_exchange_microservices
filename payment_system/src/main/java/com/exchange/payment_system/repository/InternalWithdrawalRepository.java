package com.exchange.payment_system.repository;

import com.exchange.payment_system.domain.transactions.InternalWithdrawal;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface InternalWithdrawalRepository extends JpaRepository<InternalWithdrawal, Long> {

    Optional<InternalWithdrawal> findInternalWithdrawalByIdAndStatus(Long id, String status);

}
