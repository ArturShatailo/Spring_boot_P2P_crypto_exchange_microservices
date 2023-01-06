package com.exchange.payment_methods_management.repository;

import com.exchange.payment_methods_management.domain.PayPalDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface PayPalDetailsRepository extends JpaRepository<PayPalDetails, Long> {

    Optional<PayPalDetails> findPayPalDetailsByIdAndClientEmail(Long id, String email);

}
