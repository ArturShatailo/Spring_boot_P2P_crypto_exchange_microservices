package com.exchange.market.service;

import com.exchange.market.domain.BuyAdvert;
import com.exchange.market.repository.BuyAdvertRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BuyAdvertServiceBean implements BuyAdvertService {

    private final BuyAdvertRepository buyAdvertRepository;

    @Override
    public void create(BuyAdvert buyAdvert) {

        //check verification ?
        buyAdvertRepository.save(buyAdvert);
    }
}
