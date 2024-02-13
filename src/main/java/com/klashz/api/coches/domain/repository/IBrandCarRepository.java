package com.klashz.api.coches.domain.repository;

import com.klashz.api.coches.domain.dto.BrandCarDto;

import java.util.List;
import java.util.Optional;

public interface IBrandCarRepository {
    /**
     * Devuele una marca de coche por su id
     * @param id Id de marca coche
     * @return Retorna solo un marca coche
     */
    Optional<BrandCarDto> findById(Long id);

    /**
     * Devuele una lista de los marcaCochePojo
     * @return una lista de marcaCochePojo
     */
    List<BrandCarDto> getAll();

    /**
     *
     * @param newmarcaCocheDto Nueva Marca
     * @return Marca Coche Guardado
     */
    BrandCarDto save(BrandCarDto newmarcaCocheDto);

    /**
     * Borrar marca por id
     * @param id la id de la marca a eliminar
     */
    void delete(Long id);

}
