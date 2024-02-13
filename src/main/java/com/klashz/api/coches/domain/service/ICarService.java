package com.klashz.api.coches.domain.service;

import com.klashz.api.coches.domain.dto.CarDto;

import java.util.List;
import java.util.Optional;

public interface ICarService {

    Optional<CarDto> findById(Long serial);
    List<CarDto> getAll();
    CarDto save(CarDto carDtoDto);
    boolean delete(Long  serial);
    Optional<CarDto> update(CarDto carDto);
    List<CarDto> getByIdBrandCar(Long idBrandCar);
    List<CarDto> getByPriceLessThan(Double price);
}
