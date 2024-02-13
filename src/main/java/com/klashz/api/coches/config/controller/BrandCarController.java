package com.klashz.api.coches.config.controller;
import com.klashz.api.coches.domain.dto.BrandCarDto;
import com.klashz.api.coches.domain.service.impl.MarcaCocheService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * Controlador de la entidad MarcaCoche
 */
@RestController
@RequestMapping("/marca")
public class BrandCarController {

    private final MarcaCocheService brandCarService;


    public BrandCarController(MarcaCocheService brandCarService) {
        this.brandCarService = brandCarService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<BrandCarDto> getBrandCar(@PathVariable Long id){
        return ResponseEntity.of(brandCarService.getMarca(id));
    }

    @GetMapping()
    public ResponseEntity<List<BrandCarDto>> getAllBrand(){
        return ResponseEntity.status(HttpStatus.OK)
                .body(brandCarService.getAll());
    }
    @PostMapping()
    public ResponseEntity<BrandCarDto> saveEntity(@RequestBody BrandCarDto brandCarDto){

        BrandCarDto marcaCoche = brandCarService.save(brandCarDto);
        if(marcaCoche != null){
            return  ResponseEntity.status(HttpStatus.CREATED)
                    .body(marcaCoche);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();

    }
    @PutMapping()
    public ResponseEntity<BrandCarDto>  update(@RequestBody BrandCarDto brandCarDtoUpdate){
        return ResponseEntity.of(brandCarService.update(brandCarDtoUpdate));


    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteEntity(@PathVariable Long id){
        return new ResponseEntity<>(this.brandCarService.delete(id) ?
        HttpStatus.OK : HttpStatus.NOT_FOUND
    );
    }


}
