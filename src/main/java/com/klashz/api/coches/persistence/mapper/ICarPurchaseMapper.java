package com.klashz.api.coches.persistence.mapper;

import com.klashz.api.coches.domain.dto.purchases.CarPurchaseRequestDto;
import com.klashz.api.coches.persistence.models.CarPurchaseEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ICarPurchaseMapper {
    @Mapping(target = "quantity", source = "quantityCar")
    @Mapping(target = "total",source = "totalPriceCars")
    @Mapping(source = "codeCar", target = "id.codeCar")
    @Mapping(target  = "purchaseEntity", ignore = true)
    @Mapping(target = "carEntity",ignore = true)
    @Mapping(target = "id.purchaseNumberBill",ignore = true)
    CarPurchaseEntity toCarPurchaseEntity(CarPurchaseRequestDto carPurchaseRequestDto);
}
