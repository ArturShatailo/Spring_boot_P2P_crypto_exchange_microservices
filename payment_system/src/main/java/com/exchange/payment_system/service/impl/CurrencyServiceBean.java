package com.exchange.payment_system.service.impl;

import com.exchange.payment_system.domain.Currency;
import com.exchange.payment_system.repository.CurrencyRepository;
import com.exchange.payment_system.service.CurrencyService;
import com.exchange.payment_system.util.exceptions.CurrencyNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CurrencyServiceBean implements CurrencyService {

    private final CurrencyRepository currencyRepository;


    @Override
    public Currency getById(Long id) {
        return currencyRepository.findById(id)
                .orElseThrow(() -> new CurrencyNotFoundException("Can't find Currency with id: " + id));
    }
}
