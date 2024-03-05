package com.klashz.api.coches.domain.repository;

import com.klashz.api.coches.domain.dto.CustomerDto;

import java.util.List;
import java.util.Optional;

/**
 *  Metodo de Repository
 */
public interface ICustomerRepository {


     Optional<CustomerDto>  getCustomerByCardId(String carId);
    Optional<CustomerDto> getCustomerByEmail(String email);
    List<CustomerDto> getAll();
    CustomerDto save(CustomerDto customerDto);
    void delete(String carId);
}
