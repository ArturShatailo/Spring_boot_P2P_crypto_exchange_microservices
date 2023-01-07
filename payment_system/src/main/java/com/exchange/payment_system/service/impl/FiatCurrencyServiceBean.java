package com.exchange.payment_system.service.impl;

import com.exchange.payment_system.domain.FiatCurrency;
import com.exchange.payment_system.repository.FiatCurrencyRepository;
import com.exchange.payment_system.service.CurrencyService;
import com.exchange.payment_system.util.exceptions.CurrencyNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FiatCurrencyServiceBean implements CurrencyService<FiatCurrency> {

    private final FiatCurrencyRepository currencyRepository;

    @Override
    public FiatCurrency getById(Long id) {
        return currencyRepository.findById(id)
                .orElseThrow(() -> new CurrencyNotFoundException("Can't find Fiat currency with id: " + id));
    }
}
