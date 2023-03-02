package com.exchange.payment_system.service.impl.transactions;

import com.exchange.payment_system.domain.wallets.AccountWallet;
import com.exchange.payment_system.domain.wallets.DigitalWallet;
import com.exchange.payment_system.domain.transactions.InternalWithdrawal;
import com.exchange.payment_system.repository.InternalWithdrawalRepository;
import com.exchange.payment_system.service.TransactionProcessingService;
import com.exchange.payment_system.service.WalletTransfersProcessingService;
import com.exchange.payment_system.service.validation.TransactionValidationService;
import com.exchange.payment_system.util.exceptions.InternalWithdrawalRequestNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class InternalWithdrawalProcessingServiceBean implements TransactionProcessingService<InternalWithdrawal> {

    private final InternalWithdrawalRepository internalWithdrawalRepository;

    private final WalletTransfersProcessingService<DigitalWallet> digitalWalletProcessing;

    private final WalletTransfersProcessingService<AccountWallet> accountWalletProcessing;

    private final TransactionValidationService<InternalWithdrawal> transactionValidationService;

    @Transactional
    @Override
    public InternalWithdrawal create(InternalWithdrawal transaction) {
        transactionValidationService.validate(transaction);
        return internalWithdrawalRepository.save(transaction);
    }

    @Transactional
    @Override
    public void accept(Long id) {
        internalWithdrawalRepository.findInternalWithdrawalByIdAndStatus(id, "NEW")
                .map(withdrawal -> {
                    transactionValidationService.validate(withdrawal);
                    withdrawal.setStatus("DONE");
                    digitalWalletProcessing.withdrawalConfirmed(
                            withdrawal.getFrom_digital_wallet(),
                            withdrawal.getAmount(),
                            withdrawal.getEmail()
                    );
                    accountWalletProcessing.depositConfirmed(
                            withdrawal.getTo_account_wallet(),
                            withdrawal.getAmount(),
                            withdrawal.getEmail()
                    );
                    return internalWithdrawalRepository.save(withdrawal);
                })
                .orElseThrow(() -> new InternalWithdrawalRequestNotFoundException("Can't find Internal Withdrawal request with id: " + id));
    }

    @Transactional
    @Override
    public void decline(Long id) {
        internalWithdrawalRepository.findInternalWithdrawalByIdAndStatus(id, "NEW")
                .map(withdrawal -> {
                    withdrawal.setStatus("FAIL");
                    return internalWithdrawalRepository.save(withdrawal);
                })
                .orElseThrow(() -> new InternalWithdrawalRequestNotFoundException("Can't find Internal Withdrawal request with id: " + id));

    }
}
