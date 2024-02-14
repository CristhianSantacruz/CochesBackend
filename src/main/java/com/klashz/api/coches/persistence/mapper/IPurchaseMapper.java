package com.klashz.api.coches.persistence.mapper;

import com.klashz.api.coches.domain.dto.purchases.PurchaseRequestDto;
import com.klashz.api.coches.persistence.models.PurchaseEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IPurchaseMapper {


    PurchaseRequestDto toPurchaseDto(PurchaseEntity purchaseEntity);
    @Mapping(target = "customerEntity",ignore = true)
    PurchaseEntity toPurchaseEntity(PurchaseRequestDto  purchaseRequestDto);

    List<PurchaseRequestDto> toPurchasesDto(List<PurchaseEntity> purchaseEntityList);
}
