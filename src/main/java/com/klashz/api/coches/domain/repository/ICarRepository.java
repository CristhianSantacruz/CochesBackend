package com.klashz.api.coches.domain.repository;

import com.klashz.api.coches.domain.dto.CarDto;

import java.util.List;
import java.util.Optional;
public interface ICarRepository {

    Optional<CarDto> findById(Long serial);
    List<CarDto> getAll();
    CarDto save(CarDto carDtoDto);
    void delete(Long  serial);

    List<CarDto> getByIdBrandCar(Long idBrandCar);
    List<CarDto> getByPriceLessThan(Double price);
}
