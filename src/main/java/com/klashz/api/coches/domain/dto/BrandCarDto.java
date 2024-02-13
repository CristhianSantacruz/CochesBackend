package com.klashz.api.coches.domain.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
/**
 * Pojo de Marca Coche
 */
public class BrandCarDto {
    /**
     * Id de la marca
     */
    private Long id;
    /**
     * Descripcion de la marca
     */
    private String description;

}
