package com.klashz.api.coches.exception.persistence.repository.impl;

import com.klashz.api.coches.domain.dto.CarDto;
import com.klashz.api.coches.domain.repository.ICarRepository;
import com.klashz.api.coches.exception.persistence.mapper.ICarMapper;
import com.klashz.api.coches.exception.persistence.models.CarEntity;
import com.klashz.api.coches.exception.persistence.repository.ICarJpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public class CarRepository implements ICarRepository {

    private final ICarMapper iCarMapper;
    private final ICarJpaRepository iCarJpaRepository;

    public CarRepository(ICarMapper iCarMapper, ICarJpaRepository iCarJpaRepository) {
        this.iCarMapper = iCarMapper;
        this.iCarJpaRepository = iCarJpaRepository;
    }

    @Override
    public Optional<CarDto> findById(Long serial) {
        return iCarJpaRepository.findById(serial)
                .map(iCarMapper::toCarDto);
    }

    @Override
    public List<CarDto> getAll() {
        return iCarMapper.toCarsDto(iCarJpaRepository.findAll());
    }

    @Override
    public CarDto save(CarDto carDtoDto) {
        CarEntity carEntity = iCarMapper.toCarEntity(carDtoDto);
        return iCarMapper.toCarDto(iCarJpaRepository.save(carEntity));
    }

    @Override
    public void delete(Long serial) {
        iCarJpaRepository.deleteById(serial);
    }

    @Override
    public List<CarDto> getByIdBrandCar(Long idBrandCar) {
        return iCarMapper.toCarsDto(iCarJpaRepository.findAllByBrandCarId(idBrandCar));
    }

    @Override
    public List<CarDto> getByPriceLessThan(Double price) {
        return iCarMapper.toCarsDto(iCarJpaRepository.findAllByPriceLessThanOrderByPriceDesc(price));
    }
}
