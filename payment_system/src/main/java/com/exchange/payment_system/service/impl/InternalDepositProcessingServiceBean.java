package com.exchange.payment_system.service.impl;

import com.exchange.payment_system.domain.AccountWallet;
import com.exchange.payment_system.domain.DigitalWallet;
import com.exchange.payment_system.domain.transactions.InternalDeposit;
import com.exchange.payment_system.repository.InternalDepositRepository;
import com.exchange.payment_system.service.TransactionProcessingService;
import com.exchange.payment_system.service.WalletProcessingService;
import com.exchange.payment_system.service.validation.TransactionValidationService;
import com.exchange.payment_system.util.exceptions.InternalDepositRequestNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class InternalDepositProcessingServiceBean implements TransactionProcessingService<InternalDeposit> {

    private final InternalDepositRepository internalDepositRepository;

    private final WalletProcessingService<DigitalWallet> digitalWalletProcessing;

    private final WalletProcessingService<AccountWallet> accountWalletProcessing;

    private final TransactionValidationService<InternalDeposit> transactionValidationService;

    @Transactional
    @Override
    public InternalDeposit create(InternalDeposit transaction) {
        transactionValidationService.validate(transaction);
        return internalDepositRepository.save(transaction);
    }

    @Transactional
    @Override
    public void accept(Long id) {
        internalDepositRepository.findInternalDepositByIdAndStatus(id, "NEW")
                .map(deposit -> {
                    transactionValidationService.validate(deposit);
                    deposit.setStatus("DONE");
                    accountWalletProcessing.withdrawalConfirmed(
                            deposit.getFrom_account_wallet(),
                            deposit.getAmount(),
                            deposit.getEmail()
                    );
                    digitalWalletProcessing.depositConfirmed(
                            deposit.getTo_digital_wallet(),
                            deposit.getAmount(),
                            deposit.getEmail()
                    );
                    return internalDepositRepository.save(deposit);
                })
                .orElseThrow(() -> new InternalDepositRequestNotFoundException("Can't find Internal Deposit request with id: " + id));
    }

    @Transactional
    @Override
    public void decline(Long id) {
        internalDepositRepository.findInternalDepositByIdAndStatus(id, "NEW")
                .map(deposit -> {
                    deposit.setStatus("FAIL");
                    return internalDepositRepository.save(deposit);
                })
                .orElseThrow(() -> new InternalDepositRequestNotFoundException("Can't find Internal Deposit request with id: " + id));

    }
}
