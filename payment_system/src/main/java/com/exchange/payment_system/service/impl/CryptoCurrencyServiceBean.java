package com.exchange.payment_system.service.impl;

import com.exchange.payment_system.domain.CryptoCurrency;
import com.exchange.payment_system.repository.CryptoCurrencyRepository;
import com.exchange.payment_system.service.CurrencyService;
import com.exchange.payment_system.util.exceptions.CurrencyNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CryptoCurrencyServiceBean implements CurrencyService<CryptoCurrency> {

    private final CryptoCurrencyRepository currencyRepository;

    @Override
    public CryptoCurrency getById(Long id) {
        return currencyRepository.findById(id)
                .orElseThrow(() -> new CurrencyNotFoundException("Can't find Cryptocurrency with id: " + id));
    }
}
