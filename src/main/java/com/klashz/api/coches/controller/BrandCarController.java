package com.klashz.api.coches.controller;

import com.klashz.api.coches.domain.pojo.MarcaCochePojo;
import com.klashz.api.coches.domain.service.MarcaCocheService;
import org.apache.coyote.Response;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Controlador de la entidad MarcaCoche
 */
@RestController
@RequestMapping("/api/marca")
public class BrandCarController {

    private final MarcaCocheService brandCarService;


    public BrandCarController(MarcaCocheService brandCarService) {
        this.brandCarService = brandCarService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<MarcaCochePojo> getBrandCar(@PathVariable Long id){
        return ResponseEntity.of(brandCarService.getMarca(id));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<MarcaCochePojo>> getAllBrand(){
        return ResponseEntity.status(HttpStatus.OK)
                .body(brandCarService.getAll());
    }
    @PostMapping("/save")
    public ResponseEntity<MarcaCochePojo> saveEntity(@RequestBody MarcaCochePojo marcaCochePojo){
        try{
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(brandCarService.save(marcaCochePojo));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }


}
