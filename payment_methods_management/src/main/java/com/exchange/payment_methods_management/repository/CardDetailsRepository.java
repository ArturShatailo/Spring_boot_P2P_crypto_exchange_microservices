package com.exchange.payment_methods_management.repository;

import com.exchange.payment_methods_management.domain.CardDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CardDetailsRepository extends JpaRepository<CardDetails, Long> {

    Optional<CardDetails> findCardDetailsByIdAndClientEmail(Long id, String email);

}
