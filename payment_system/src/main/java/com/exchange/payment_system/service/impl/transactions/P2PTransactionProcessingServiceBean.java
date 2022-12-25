package com.exchange.payment_system.service.impl.transactions;

import com.exchange.payment_system.domain.transactions.P2PTransaction;
import com.exchange.payment_system.repository.P2PTransactionRepository;
import com.exchange.payment_system.service.TransactionProcessingService;
import com.exchange.payment_system.service.WalletP2PProcessingService;
import com.exchange.payment_system.util.exceptions.P2PTransactionNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class P2PTransactionProcessingServiceBean implements TransactionProcessingService<P2PTransaction> {

    private final P2PTransactionRepository p2pTransactionRepository;

    private final WalletP2PProcessingService digitalWalletProcessing;

    @Transactional
    @Override
    public P2PTransaction create(P2PTransaction transaction) {
        digitalWalletProcessing.p2pDigitalWalletHoldFunds(
                transaction.getFrom_wallet(),
                transaction.getAmount(),
                transaction.getEmail_from()
        );
        return p2pTransactionRepository.save(transaction);
    }

    @Transactional
    @Override
    public void accept(Long id) {
        p2pTransactionRepository.findP2PTransactionByIdAndStatus(id, "NEW")
                .map(transaction -> {
                    transaction.setStatus("DONE");
                    digitalWalletProcessing.p2pWithdrawalConfirmed(
                            transaction.getFrom_wallet(),
                            transaction.getAmount(),
                            transaction.getEmail_from()
                    );
                    digitalWalletProcessing.p2pDepositConfirmed(
                            transaction.getTo_wallet(),
                            transaction.getAmount(),
                            transaction.getEmail_to()
                    );
                    return p2pTransactionRepository.save(transaction);
                })
                .orElseThrow(() -> new P2PTransactionNotFoundException("Can't find p2p transaction request with id: " + id));
    }

    @Transactional
    @Override
    public void decline(Long id) {
        p2pTransactionRepository.findP2PTransactionByIdAndStatus(id, "NEW")
                .map(transaction -> {
                    transaction.setStatus("FAIL");
                    return p2pTransactionRepository.save(transaction);
                })
                .orElseThrow(() -> new P2PTransactionNotFoundException("Can't find p2p transaction request with id: " + id));

    }
}
