package com.exchange.payment_system.service.impl.transactions;

import com.exchange.payment_system.domain.wallets.AccountWallet;
import com.exchange.payment_system.domain.transactions.WithdrawalRequest;
import com.exchange.payment_system.repository.WithdrawalRequestRepository;
import com.exchange.payment_system.service.TransactionProcessingService;
import com.exchange.payment_system.service.WalletTransfersProcessingService;
import com.exchange.payment_system.service.validation.TransactionValidationService;
import com.exchange.payment_system.util.exceptions.WithdrawalRequestNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class WithdrawalRequestProcessingServiceBean implements TransactionProcessingService<WithdrawalRequest> {

    private final WithdrawalRequestRepository withdrawalRequestRepository;

    private final WalletTransfersProcessingService<AccountWallet> walletTransfersProcessingService;

    private final TransactionValidationService<WithdrawalRequest> transactionValidationService;

    @Transactional
    @Override
    public WithdrawalRequest create(WithdrawalRequest withdrawalRequest) {
        transactionValidationService.validate(withdrawalRequest);
        return withdrawalRequestRepository.save(withdrawalRequest);
    }

    //TODO: Optimize status filter
    @Transactional
    @Override
    public void accept(Long id) {
        withdrawalRequestRepository.findWithdrawalRequestByIdAndStatus(id, "NEW")
                .map(withdrawal -> {
                    transactionValidationService.validate(withdrawal);
                    withdrawal.setStatus("DONE");
                    walletTransfersProcessingService.withdrawalConfirmed(
                            withdrawal.getWallet(),
                            withdrawal.getAmount(),
                            withdrawal.getEmail()
                    );
                    return withdrawalRequestRepository.save(withdrawal);
                })
                .orElseThrow(() -> new WithdrawalRequestNotFoundException("Can't find Withdrawal request with id: " + id));
    }

    //TODO: Optimize status filter
    @Transactional
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
