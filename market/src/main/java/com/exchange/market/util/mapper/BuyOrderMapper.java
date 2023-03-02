package com.exchange.market.util.mapper;

import com.exchange.market.domain.BuyOrder;
import com.exchange.market.domain.dto.BuyOrderDTO;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = BuyOrderMapper.class, injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface BuyOrderMapper {

    BuyOrderDTO objectToBuyOrderDTO(BuyOrder object);

    BuyOrder buyOrderDTOtoObject(BuyOrderDTO dto);

}
