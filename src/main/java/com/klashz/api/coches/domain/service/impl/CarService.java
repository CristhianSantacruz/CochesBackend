package com.klashz.api.coches.domain.service.impl;

import com.klashz.api.coches.domain.dto.CarDto;
import com.klashz.api.coches.domain.repository.ICarRepository;
import com.klashz.api.coches.domain.service.ICarService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

/**
 * Servicio de Coche Logica de Negocio
 */
@Service
public class CarService  implements ICarService {

    private final ICarRepository iCarRepository;

    public CarService(ICarRepository iCarRepository) {
        this.iCarRepository = iCarRepository;
    }


    @Override
    public Optional<CarDto> findById(Long serial) {
        return iCarRepository.findById(serial);
    }

    @Override
    public List<CarDto> getAll() {
        return iCarRepository.getAll();
    }

    @Override
    public CarDto save(CarDto carDtoDto) {
        return iCarRepository.save(carDtoDto);
    }

    @Override
    public boolean delete(Long serial) {
        if(iCarRepository.findById(serial).isEmpty()){
            return false;
        }
         iCarRepository.delete(serial);
        return true;
    }

    @Override
    public Optional<CarDto> update(CarDto carDto) {
        if(iCarRepository.findById(carDto.getSerial()).isEmpty()){
            return Optional.empty();
        }

        return Optional.of(iCarRepository.save(carDto));
    }

    @Override
    public List<CarDto> getByIdBrandCar(Long idBrandCar) {
        return iCarRepository.getByIdBrandCar(idBrandCar);
    }

    @Override
    public List<CarDto> getByPriceLessThan(Double price) {
        return iCarRepository.getByPriceLessThan(price);
    }
}
