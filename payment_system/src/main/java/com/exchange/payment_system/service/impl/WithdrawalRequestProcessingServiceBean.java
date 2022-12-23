package com.exchange.payment_system.service.impl;

import com.exchange.payment_system.domain.WithdrawalRequest;
import com.exchange.payment_system.repository.WithdrawalRequestRepository;
import com.exchange.payment_system.service.AccountWalletProcessingService;
import com.exchange.payment_system.service.WithdrawalRequestProcessingService;
import com.exchange.payment_system.service.validation.WithdrawalRequestValidationService;
import com.exchange.payment_system.util.exceptions.WithdrawalRequestNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class WithdrawalRequestProcessingServiceBean implements WithdrawalRequestProcessingService {

    private final WithdrawalRequestRepository withdrawalRequestRepository;

    private final AccountWalletProcessingService accountWalletProcessingService;

    private final WithdrawalRequestValidationService withdrawalRequestValidationService;

    @Transactional
    @Override
    public WithdrawalRequest create(WithdrawalRequest withdrawalRequest) {
        withdrawalRequestValidationService.validate(withdrawalRequest);
        return withdrawalRequestRepository.save(withdrawalRequest);
    }

    //TODO: Optimize status filter
    @Transactional
    @Override
    public void accept(Long id) {
        withdrawalRequestRepository.findWithdrawalRequestByIdAndStatus(id, "NEW")
                .map(withdrawal -> {
                    withdrawalRequestValidationService.validate(withdrawal);
                    withdrawal.setStatus("DONE");
                    accountWalletProcessingService.withdrawalConfirmed(
                            withdrawal.getWallet(),
                            withdrawal.getAmount(),
                            withdrawal.getEmail()
                    );
                    return withdrawalRequestRepository.save(withdrawal);
                })
                .orElseThrow(() -> new WithdrawalRequestNotFoundException("Can't find Withdrawal request with id: " + id));
    }

    //TODO: Optimize status filter
    @Override
    public void decline(Long id) {
        withdrawalRequestRepository.findWithdrawalRequestByIdAndStatus(id, "NEW")
                .map(withdrawal -> {
                    withdrawal.setStatus("FAIL");
                    return withdrawalRequestRepository.save(withdrawal);
                })
                .orElseThrow(() -> new WithdrawalRequestNotFoundException("Can't find Withdrawal request with id: " + id));
    }

}
