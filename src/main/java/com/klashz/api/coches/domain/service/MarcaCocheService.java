package com.klashz.api.coches.domain.service;

import com.klashz.api.coches.domain.pojo.MarcaCochePojo;
import com.klashz.api.coches.domain.repository.IMarcaCocheRepository;
import com.klashz.api.coches.persistence.mapper.IMarcaCocheMapper;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Servicio de Marca Coche
 */
@Service

public class MarcaCocheService implements IMarcaCocheService {

    private final IMarcaCocheRepository iMarcaCocheRepository;

    public MarcaCocheService(IMarcaCocheRepository iMarcaCocheRepository) {
        this.iMarcaCocheRepository = iMarcaCocheRepository;
    }


    @Override
    public Optional<MarcaCochePojo> getMarca(Long id) {
        return iMarcaCocheRepository.findById(id);
    }

    @Override
    public List<MarcaCochePojo> getAll() {
        return iMarcaCocheRepository.getAll();
    }

    @Override
    public MarcaCochePojo save(MarcaCochePojo newmarcaCochePojo) {
        return iMarcaCocheRepository.save(newmarcaCochePojo);
    }

    @Override
    public boolean delete(Long id) {
        try {
            iMarcaCocheRepository.delete(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
