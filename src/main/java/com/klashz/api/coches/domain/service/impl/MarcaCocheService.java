package com.klashz.api.coches.domain.service.impl;

import com.klashz.api.coches.domain.dto.BrandCarDto;
import com.klashz.api.coches.domain.repository.IBrandCarRepository;
import com.klashz.api.coches.domain.service.IMarcaCocheService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Servicio de Marca Coche
 */
@Service

public class MarcaCocheService implements IMarcaCocheService {

    private final IBrandCarRepository iBrandCarRepository;

    public MarcaCocheService(IBrandCarRepository iBrandCarRepository) {
        this.iBrandCarRepository = iBrandCarRepository;
    }


    @Override
    public Optional<BrandCarDto> getMarca(Long id) {
        return iBrandCarRepository.findById(id);
    }

    @Override
    public List<BrandCarDto> getAll() {
        return iBrandCarRepository.getAll();
    }

    @Override
    public BrandCarDto save(BrandCarDto newmarcaCocheDto) {
        return iBrandCarRepository.save(newmarcaCocheDto);
    }

    @Override
    public Optional<BrandCarDto> update(BrandCarDto brandCarDto) {
      if( iBrandCarRepository.findById(brandCarDto.getId())
              .isEmpty()){
          return  Optional.empty();
      }
        return Optional.of(iBrandCarRepository.save(brandCarDto));
    }

    @Override
    public boolean delete(Long id) {
        if(iBrandCarRepository.findById(id).isEmpty()){
            return false;
        }
        iBrandCarRepository.delete(id);
        return true;
    }
}
