package com.exchange.payment_methods_management.util.mapper;

import com.exchange.payment_methods_management.domain.BankDetails;
import com.exchange.payment_methods_management.domain.dto.BankDetailsDTO;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = BankDetailsMapper.class, injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface BankDetailsMapper {

    BankDetailsDTO objectToBankDetailsDTO(BankDetails object);

    BankDetails bankDetailsDTOtoObject(BankDetailsDTO dto);

}
