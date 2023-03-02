package com.exchange.market.util.mapper;

import com.exchange.market.domain.BuyAdvert;
import com.exchange.market.domain.dto.BuyAdvertDTO;
import com.exchange.market.domain.dto.BuyAdvertInfoDTO;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = BuyAdvertMapper.class, injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface BuyAdvertMapper {

    BuyAdvertDTO objectToBuyAdvertDTO(BuyAdvert object);

    BuyAdvert buyAdvertDTOtoObject(BuyAdvertDTO dto);

    BuyAdvertInfoDTO objectToBuyAdvertInfoDTO(BuyAdvert object);

    BuyAdvert buyAdvertInfoDTOtoObject(BuyAdvertInfoDTO dto);

}
