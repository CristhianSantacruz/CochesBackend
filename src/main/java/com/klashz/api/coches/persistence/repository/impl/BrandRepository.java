package com.klashz.api.coches.persistence.repository.impl;

import com.klashz.api.coches.domain.dto.BrandCarDto;
import com.klashz.api.coches.domain.repository.IBrandCarRepository;
import com.klashz.api.coches.persistence.mapper.IBrandMapper;
import com.klashz.api.coches.persistence.models.BrandCarEntity;
import com.klashz.api.coches.persistence.repository.IBrandJpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
@Repository
public class BrandRepository implements IBrandCarRepository {

    private final IBrandJpaRepository iBrandJpaRepository;
    private final IBrandMapper iBrandMapper;

    public BrandRepository(IBrandJpaRepository iBrandJpaRepository, IBrandMapper iBrandMapper) {
        this.iBrandJpaRepository = iBrandJpaRepository;
        this.iBrandMapper = iBrandMapper;
    }

    @Override
    public Optional<BrandCarDto> findById(Long id) {
        return iBrandJpaRepository.findById(id)
                .map(iBrandMapper::toBrandCarDto);
    }

    @Override
    public List<BrandCarDto> getAll() {
        return iBrandMapper.toBrandCarsDto(iBrandJpaRepository.findAll());
    }

    @Override
    public BrandCarDto save(BrandCarDto newmarcaCocheDto) {
        BrandCarEntity brandCarEntity = iBrandMapper.toBrandCarEntity(newmarcaCocheDto);
        return iBrandMapper.toBrandCarDto(iBrandJpaRepository.save(brandCarEntity));
    }

    @Override
    public void delete(Long id) {
        iBrandJpaRepository.deleteById(id);
    }
}
