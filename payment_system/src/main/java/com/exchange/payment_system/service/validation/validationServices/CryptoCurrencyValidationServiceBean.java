package com.exchange.payment_system.service.validation.validationServices;

import com.exchange.payment_system.domain.CryptoCurrency;
import com.exchange.payment_system.util.exceptions.CurrenciesAreNotEqualsException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CryptoCurrencyValidationServiceBean implements CurrenciesValidation<CryptoCurrency> {

    @Override
    public void validateCurrencies(CryptoCurrency c, CryptoCurrency c1) {
        if (!c.equals(c1))
            throw new CurrenciesAreNotEqualsException("Cryptocurrency: " + c.getName() + " cannot be transferred into cryptocurrency: " + c1.getName());
    }
}
