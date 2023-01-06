package com.exchange.payment_methods_management.repository;

import com.exchange.payment_methods_management.domain.PaymentMethod;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentMethodRepository extends JpaRepository<PaymentMethod, Long> {
}
