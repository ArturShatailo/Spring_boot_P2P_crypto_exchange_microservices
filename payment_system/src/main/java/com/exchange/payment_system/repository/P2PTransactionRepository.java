package com.exchange.payment_system.repository;

import com.exchange.payment_system.domain.transactions.P2PTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface P2PTransactionRepository extends JpaRepository<P2PTransaction, Long> {

    Optional<P2PTransaction> findP2PTransactionByIdAndStatus(Long id, String status);

}
