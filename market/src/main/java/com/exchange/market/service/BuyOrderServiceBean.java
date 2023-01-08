package com.exchange.market.service;

import com.exchange.market.domain.BuyOrder;
import com.exchange.market.repository.BuyOrderRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BuyOrderServiceBean implements BuyOrderService {

    private final BuyOrderRepository buyOrderRepository;

    @Override
    @Transactional
    public void create(BuyOrder buyOrder) {
        //validate
        //timer start
        //p2p payment
        //notification
        //buy order create
    }
}
