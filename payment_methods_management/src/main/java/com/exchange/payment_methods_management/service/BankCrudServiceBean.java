package com.exchange.payment_methods_management.service;

import com.exchange.payment_methods_management.domain.Bank;
import com.exchange.payment_methods_management.repository.BankRepository;
import com.exchange.payment_methods_management.util.exceptions.BankNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BankCrudServiceBean implements CrudService<Bank, Long> {

    private final BankRepository bankRepository;

    @Override
    public Bank create(Bank bank) {
        return bankRepository.save(bank);
    }

    @Override
    public void update(Bank bank, Long id) {
        bankRepository.findById(id)
                .map(b -> {
                    b.setName(bank.getName());
                    b.setCode(bank.getCode());
                    return bankRepository.save(b);
                })
                .orElseThrow(() -> new BankNotFoundException("Bank with ID: " + id + "is not found"));
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Bank bank = bankRepository.findById(id)
                .orElseThrow(() -> new BankNotFoundException("Bank with ID: " + id + "is not found"));
        bankRepository.delete(bank);
    }

    @Override
    public List<Bank> getAll() {
        return bankRepository.findAll();
    }

    @Override
    public Bank get(Long id) {
        return bankRepository.findById(id)
                .orElseThrow(() -> new BankNotFoundException("Bank with ID: " + id + "is not found"));
    }
}
