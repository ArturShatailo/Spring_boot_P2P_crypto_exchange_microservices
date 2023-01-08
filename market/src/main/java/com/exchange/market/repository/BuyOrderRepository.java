package com.exchange.market.repository;

import com.exchange.market.domain.BuyOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BuyOrderRepository extends JpaRepository<BuyOrder, Long> {
}
