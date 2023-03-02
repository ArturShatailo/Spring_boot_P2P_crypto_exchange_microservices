package com.exchange.payment_methods_management.repository;

import com.exchange.payment_methods_management.domain.BankDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface BankDetailsRepository extends JpaRepository<BankDetails, Long> {

    Optional<BankDetails> findBankDetailsByIdAndClientEmail(Long id, String email);

}
