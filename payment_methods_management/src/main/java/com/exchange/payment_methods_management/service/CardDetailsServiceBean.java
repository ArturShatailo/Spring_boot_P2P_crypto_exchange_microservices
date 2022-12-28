package com.exchange.payment_methods_management.service;

import com.exchange.payment_methods_management.domain.CardDetails;
import com.exchange.payment_methods_management.repository.CardDetailsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CardDetailsServiceBean implements CardDetailsService{

    private final CardDetailsRepository cardDetailsRepository;

    @Override
    public void add(CardDetails cardDetails) {
        cardDetailsRepository.save(cardDetails);
    }
}
