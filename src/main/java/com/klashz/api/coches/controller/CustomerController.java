package com.klashz.api.coches.controller;
import com.klashz.api.coches.domain.dto.CustomerDto;
import com.klashz.api.coches.domain.dto.CustomerPasswordDto;
import com.klashz.api.coches.domain.service.impl.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


/**
 *  Controlador del Cliente
 */

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/id/{cardId}")
    public ResponseEntity<CustomerDto> findById(@PathVariable String cardId){
        return ResponseEntity.of(customerService.findById(cardId));
    }

    @GetMapping
    public ResponseEntity<List<CustomerDto>> findAll(){
        return ResponseEntity.ok(customerService.getAll());
    }

    @GetMapping("/{email}")
    public ResponseEntity<CustomerDto> findByEmail(@PathVariable String email){
        return ResponseEntity.of(customerService.findByEmail(email));
    }
    @PostMapping
    public ResponseEntity<CustomerPasswordDto> save(@RequestBody CustomerDto customerDto){
        CustomerPasswordDto customerDto1 = customerService.save(customerDto);
        if(customerDto1 != null){
            return  ResponseEntity.status(HttpStatus.CREATED)
                    .body(customerDto1);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
    @PutMapping()
    public ResponseEntity<CustomerDto> update(@RequestBody CustomerDto customerDto){
        return ResponseEntity.of(customerService.update(customerDto));
    }

    @DeleteMapping("/{cardId}")
    public ResponseEntity<Boolean> delete(@PathVariable String cardId){
        return new ResponseEntity<>(customerService.delete(cardId)
                ? HttpStatus.OK :
                HttpStatus.NOT_FOUND);
    }

    
}
