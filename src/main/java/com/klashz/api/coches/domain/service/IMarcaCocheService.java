package com.klashz.api.coches.domain.service;

import com.klashz.api.coches.domain.dto.BrandCarDto;

import java.util.List;
import java.util.Optional;

public interface IMarcaCocheService {
    /**
     * Devuele una marca de coche por su id
     *
     * @param id Id de marca coche
     * @return Retorna solo un marca coche
     */
    Optional<BrandCarDto> getMarca(Long id);

    /**
     * Devuele una lista de los marcaCochePojo
     *
     * @return una lista de marcaCochePojo
     */
    List<BrandCarDto> getAll();

    /**
     * @param newmarcaCocheDto Nueva Marca
     * @return Marca Coche Guardado
     */
    BrandCarDto save(BrandCarDto newmarcaCocheDto);
   Optional<BrandCarDto> update(BrandCarDto brandCarDto);

    /**
     * Borrar marca por id
     *
     * @param id la id de la marca a eliminar
     */
    boolean delete(Long id);
}