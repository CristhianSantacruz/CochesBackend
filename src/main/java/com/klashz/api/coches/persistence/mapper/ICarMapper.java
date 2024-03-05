package com.klashz.api.coches.persistence.mapper;

import com.klashz.api.coches.domain.dto.CarDto;
import com.klashz.api.coches.persistence.models.CarEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ICarMapper {

    @Mapping(source = "brandCarEntity.description", target = "brandCarEntity")
    CarDto toCarDto(CarEntity carEntity);

    @Mapping(target = "brandCarEntity",ignore = true)
    @Mapping(target="carPurchaseEntities",ignore = true)
    CarEntity toCarEntity(CarDto carDto);

    List<CarDto> toCarsDto(List<CarEntity> carEntityList);
}
