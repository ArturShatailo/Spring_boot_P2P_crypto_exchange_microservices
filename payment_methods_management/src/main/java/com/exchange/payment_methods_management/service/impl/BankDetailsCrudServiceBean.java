package com.exchange.payment_methods_management.service.impl;

import com.exchange.payment_methods_management.domain.BankDetails;
import com.exchange.payment_methods_management.repository.BankDetailsRepository;
import com.exchange.payment_methods_management.service.DetailsCrudService;
import com.exchange.payment_methods_management.util.exceptions.BankDetailsNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BankDetailsCrudServiceBean implements DetailsCrudService<BankDetails, Long> {

    private final BankDetailsRepository bankDetailsRepository;

    @Override
    public void add(BankDetails bankDetails) {
        bankDetailsRepository.save(bankDetails);
    }

    @Override
    public void update(BankDetails bankDetails, Long id) {
        bankDetailsRepository.findBankDetailsByIdAndClientEmail(id, bankDetails.getClientEmail())
                .map(bd ->{
                    bd.setName(bankDetails.getName());
                    bd.setIban(bankDetails.getIban());
                    bd.setBank(bankDetails.getBank());
                    bd.setSurname(bankDetails.getSurname());
                    return bankDetailsRepository.save(bd);
                })
                .orElseThrow(() -> new BankDetailsNotFoundException("Can't find bank details with email: " + bankDetails.getClientEmail() + " and id: " + id));
    }

    @Override
    public void delete(Long id, String email) {
        bankDetailsRepository.findBankDetailsByIdAndClientEmail(id, email)
                .map(bd -> {
                    bd.setDeleted(true);
                    return bankDetailsRepository.save(bd);
                });
    }

    @Override
    public BankDetails get(Long id, String email) {
        return bankDetailsRepository.findBankDetailsByIdAndClientEmail(id, email)
                .orElseThrow(() -> new BankDetailsNotFoundException("Can't find bank details with email: " + email + " and id: " + id));
    }

}
