package com.exchange.payment_methods_management.repository;

import com.exchange.payment_methods_management.domain.CardDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardDetailsRepository extends JpaRepository<CardDetails, Long> {
}
