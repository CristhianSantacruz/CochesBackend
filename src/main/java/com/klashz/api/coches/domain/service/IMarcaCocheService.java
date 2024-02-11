package com.klashz.api.coches.domain.service;

import com.klashz.api.coches.domain.pojo.MarcaCochePojo;
import com.klashz.api.coches.domain.repository.IMarcaCocheRepository;

import java.util.List;
import java.util.Optional;

public interface IMarcaCocheService {
    /**
     * Devuele una marca de coche por su id
     *
     * @param id Id de marca coche
     * @return Retorna solo un marca coche
     */
    Optional<MarcaCochePojo> getMarca(Long id);

    /**
     * Devuele una lista de los marcaCochePojo
     *
     * @return una lista de marcaCochePojo
     */
    List<MarcaCochePojo> getAll();

    /**
     * @param newmarcaCochePojo Nueva Marca
     * @return Marca Coche Guardado
     */
    MarcaCochePojo save(MarcaCochePojo newmarcaCochePojo);

    /**
     * Borrar marca por id
     *
     * @param id la id de la marca a eliminar
     */
    boolean delete(Long id);
}