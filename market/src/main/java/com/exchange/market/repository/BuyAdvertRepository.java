package com.exchange.market.repository;

import com.exchange.market.domain.BuyAdvert;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BuyAdvertRepository extends JpaRepository<BuyAdvert, Long> {
}
