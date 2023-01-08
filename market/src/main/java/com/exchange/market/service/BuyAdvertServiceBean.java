package com.exchange.market.service;

import com.exchange.market.domain.BuyAdvert;
import com.exchange.market.repository.BuyAdvertRepository;
import com.exchange.market.service.validation.AdvertValidationService;
import com.exchange.market.util.exceptions.BuyAdvertNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BuyAdvertServiceBean implements BuyAdvertService {

    private final BuyAdvertRepository buyAdvertRepository;

    private final AdvertValidationService<BuyAdvert> buyAdvertValidation;

    @Override
    @Transactional
    public void create(BuyAdvert buyAdvert) {
        buyAdvertValidation.validate(buyAdvert);
        //hold funds on dw
        buyAdvertRepository.save(buyAdvert);
    }

    @Override
    public BuyAdvert getInfo(Long id) {
        return buyAdvertRepository.findById(id)
                .orElseThrow(() -> new BuyAdvertNotFoundException("Can't find advert with id: " + id));
    }
}
