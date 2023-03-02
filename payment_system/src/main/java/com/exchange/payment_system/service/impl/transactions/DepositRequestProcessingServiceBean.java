package com.exchange.payment_system.service.impl.transactions;

import com.exchange.payment_system.domain.wallets.AccountWallet;
import com.exchange.payment_system.domain.transactions.DepositRequest;
import com.exchange.payment_system.repository.DepositRequestRepository;
import com.exchange.payment_system.service.TransactionProcessingService;
import com.exchange.payment_system.service.WalletTransfersProcessingService;
import com.exchange.payment_system.service.validation.TransactionValidationService;
import com.exchange.payment_system.util.exceptions.DepositRequestNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DepositRequestProcessingServiceBean implements TransactionProcessingService<DepositRequest> {

    private final DepositRequestRepository depositRequestRepository;

    private final TransactionValidationService<DepositRequest> transactionValidationService;

    private final WalletTransfersProcessingService<AccountWallet> walletTransfersProcessingService;

    @Transactional
    @Override
    public DepositRequest create(DepositRequest depositRequest) {
        transactionValidationService.validate(depositRequest);
        return depositRequestRepository.save(depositRequest);
    }

    //TODO: Optimize status filter
    @Transactional
    @Override
    public void accept(Long id) {
        depositRequestRepository.findDepositRequestByIdAndStatus(id, "NEW")
                .map(deposit -> {
                    deposit.setStatus("DONE");
                    walletTransfersProcessingService.depositConfirmed(
                            deposit.getWallet(),
                            deposit.getAmount(),
                            deposit.getEmail()
                    );
                    return depositRequestRepository.save(deposit);
                })
                .orElseThrow(() -> new DepositRequestNotFoundException("Can't find Deposit request with id: " + id));
    }

    //TODO: Optimize status filter
    @Transactional
    @Override
    public void decline(Long id) {
        depositRequestRepository.findDepositRequestByIdAndStatus(id, "NEW")
                .map(depositRequest -> {
                    depositRequest.setStatus("FAIL");
                    return depositRequestRepository.save(depositRequest);
                })
                .orElseThrow(() -> new DepositRequestNotFoundException("Can't find Deposit request with id: " + id));
    }

}
