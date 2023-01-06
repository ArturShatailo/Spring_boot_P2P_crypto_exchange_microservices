package com.exchange.payment_methods_management.util.mapper;

import com.exchange.payment_methods_management.domain.Bank;
import com.exchange.payment_methods_management.domain.dto.BankSaveDTO;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = BankMapper.class, injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface BankMapper {

    BankSaveDTO objectToBankSaveDTO(Bank object);

    Bank bankSaveDTOtoObject(BankSaveDTO dto);

}
