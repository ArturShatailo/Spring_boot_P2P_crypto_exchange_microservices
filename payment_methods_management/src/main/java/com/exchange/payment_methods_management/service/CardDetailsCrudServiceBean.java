package com.exchange.payment_methods_management.service;

import com.exchange.payment_methods_management.domain.CardDetails;
import com.exchange.payment_methods_management.repository.CardDetailsRepository;
import com.exchange.payment_methods_management.util.exceptions.CardDetailsNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CardDetailsCrudServiceBean implements DetailsCrudService<CardDetails, Long>{

    private final CardDetailsRepository cardDetailsRepository;

    @Override
    public void add(CardDetails cardDetails) {
        cardDetailsRepository.save(cardDetails);
    }

    @Override
    public void update(CardDetails cardDetails, Long id) {
        cardDetailsRepository.findCardDetailsByIdAndClientEmail(id, cardDetails.getClientEmail())
                .map(cd ->{
                    cd.setName(cardDetails.getName());
                    cd.setNumber(cardDetails.getNumber());
                    cd.setBankIssuer(cardDetails.getBankIssuer());
                    cd.setSurname(cardDetails.getSurname());
                    return cardDetailsRepository.save(cd);
                })
                .orElseThrow(() -> new CardDetailsNotFoundException("Can't find card details with email: " + cardDetails.getClientEmail() + " and id: " + id));
    }

    @Override
    public void delete(Long id, String email) {
        cardDetailsRepository.findCardDetailsByIdAndClientEmail(id, email)
                .map(cd -> {
                    cd.setDeleted(true);
                    return cardDetailsRepository.save(cd);
                });
    }

    @Override
    public CardDetails get(Long id, String email) {
        return cardDetailsRepository.findCardDetailsByIdAndClientEmail(id, email)
                .orElseThrow(() -> new CardDetailsNotFoundException("Can't find card details with email: " + email + " and id: " + id));
    }

}
