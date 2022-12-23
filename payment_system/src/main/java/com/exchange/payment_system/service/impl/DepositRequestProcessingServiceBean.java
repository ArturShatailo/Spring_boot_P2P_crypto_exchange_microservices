package com.exchange.payment_system.service.impl;

import com.exchange.payment_system.domain.DepositRequest;
import com.exchange.payment_system.repository.DepositRequestRepository;
import com.exchange.payment_system.service.AccountWalletProcessingService;
import com.exchange.payment_system.service.DepositRequestProcessingService;
import com.exchange.payment_system.util.exceptions.DepositRequestNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DepositRequestProcessingServiceBean implements DepositRequestProcessingService {

    private final DepositRequestRepository depositRequestRepository;

    private final AccountWalletProcessingService accountWalletProcessingService;

    @Override
    public DepositRequest create(DepositRequest depositRequest) {
        return depositRequestRepository.save(depositRequest);
    }

    //TODO: Optimize status filter
    @Transactional
    @Override
    public void accept(Long id) {
        depositRequestRepository.findDepositRequestByIdAndStatus(id, "NEW")
                .map(deposit -> {
                    deposit.setStatus("DONE");
                    accountWalletProcessingService.depositConfirmed(
                            deposit.getWallet(),
                            deposit.getAmount(),
                            deposit.getEmail()
                    );
                    return depositRequestRepository.save(deposit);
                })
                .orElseThrow(() -> new DepositRequestNotFoundException("Can't find Deposit request with id: " + id));
    }

    //TODO: Optimize status filter
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
