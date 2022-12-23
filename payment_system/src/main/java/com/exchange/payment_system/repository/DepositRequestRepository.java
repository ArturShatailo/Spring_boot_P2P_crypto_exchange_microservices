package com.exchange.payment_system.repository;

import com.exchange.payment_system.domain.DepositRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DepositRequestRepository extends JpaRepository<DepositRequest, Long> {

    Optional<DepositRequest> findDepositRequestByIdAndStatus(Long id, String status);

}
