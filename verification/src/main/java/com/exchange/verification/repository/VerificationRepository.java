package com.exchange.verification.repository;

import com.exchange.verification.domain.Verification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VerificationRepository extends JpaRepository<Verification, Long> {

    Optional<Verification> findVerificationByEmail(String email);

}
