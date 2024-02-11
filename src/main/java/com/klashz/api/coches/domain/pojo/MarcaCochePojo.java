package com.klashz.api.coches.domain.pojo;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
/**
 * Pojo de Marca Coche
 */
public class MarcaCochePojo {
    /**
     * Id de la marca
     */
    private Long id;
    /**
     * Descripcion de la marca
     */
    private String description;

}
