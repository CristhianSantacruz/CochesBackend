package com.klashz.api.coches.controller;

import com.klashz.api.coches.domain.dto.CarDto;

import com.klashz.api.coches.domain.service.impl.CarService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador de el Coche
 */
@RestController
@RequestMapping("/car")
public class CarController {
    private final CarService carService;
    public CarController(CarService carService) {
        this.carService = carService;
    }
    @GetMapping("/{serial}")
    public ResponseEntity<CarDto> findById(@PathVariable Long serial){
        return ResponseEntity.of(carService.findById(serial));
    }
    @GetMapping()
    public ResponseEntity<List<CarDto>> getAll(){
        return ResponseEntity.ok(carService.getAll());
    }
    @GetMapping("/brands/{id}")
    public ResponseEntity<List<CarDto>> getAllCarsByBrandId(@PathVariable Long id){
        return ResponseEntity.ok(carService.getByIdBrandCar(id));
    }
    @GetMapping("/prices/{price}")
    public ResponseEntity<List<CarDto>> getAllCarsByPriceLessThan(@PathVariable Double price){
        return ResponseEntity.ok(carService.getByPriceLessThan(price));
    }
    @PostMapping()
    public ResponseEntity<CarDto> save(CarDto carDto){
        CarDto carDto1 = carService.save(carDto);
        if(carDto1!= null){
            return  ResponseEntity.status(HttpStatus.CREATED)
                    .body(carDto1);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
    @PutMapping()
    public ResponseEntity<CarDto> update(CarDto carDto){
        return ResponseEntity.of(carService.update(carDto));
    }

    @DeleteMapping
    public ResponseEntity<Boolean> delete(Long serial){
        return new ResponseEntity<>(carService.delete(serial) ?
                HttpStatus.OK :
                HttpStatus.NOT_FOUND);
    }

}
