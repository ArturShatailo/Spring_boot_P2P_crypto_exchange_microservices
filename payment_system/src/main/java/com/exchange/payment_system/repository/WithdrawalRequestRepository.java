package com.exchange.payment_system.repository;

import com.exchange.payment_system.domain.WithdrawalRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface WithdrawalRequestRepository extends JpaRepository<WithdrawalRequest, Long> {

    Optional<WithdrawalRequest> findWithdrawalRequestByIdAndStatus(Long id, String status);

}
