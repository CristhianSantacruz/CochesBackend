package com.klashz.api.coches.persistence.mapper;

import com.klashz.api.coches.domain.pojo.MarcaCochePojo;
import com.klashz.api.coches.persistence.models.MarcaCocheEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IMarcaCocheMapper {
    /**
     *Covierte una entidad a un pojo
     * @param marcaCocheEntity Entidad a convertir
     * source = origen
     * target = destino
     * @return Pojo Convertido
     */
    @Mapping(source = "id",target = "id")
    @Mapping(source = "description",target = "description")
    MarcaCochePojo toMarcaCochePojo(MarcaCocheEntity marcaCocheEntity);


    @InheritInverseConfiguration
    MarcaCocheEntity toMarcaCocheEntity(MarcaCochePojo marcaCochePojo);


    List<MarcaCochePojo> toMarcaCochePojo(List<MarcaCocheEntity> marcaCocheEntityList);
}
