package com.klashz.api.coches.exception.persistence.mapper;

import com.klashz.api.coches.domain.dto.BrandCarDto;
import com.klashz.api.coches.exception.persistence.models.BrandCarEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IBrandMapper {
    @Mapping(source = "id",target = "id")
    @Mapping(source = "description",target = "description")
    BrandCarDto toBrandCarDto(BrandCarEntity brandCarEntity);

    @InheritInverseConfiguration
    @Mapping(target = "carEntities",ignore = true)
    BrandCarEntity toBrandCarEntity(BrandCarDto brandCarDto);

    List<BrandCarDto> toBrandCarsDto(List<BrandCarEntity> brandCarEntityList);
}
