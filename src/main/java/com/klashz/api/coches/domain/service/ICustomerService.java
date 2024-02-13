package com.klashz.api.coches.domain.service;

import com.klashz.api.coches.domain.dto.CustomerDto;
import com.klashz.api.coches.domain.dto.CustomerPasswordDto;

import java.util.List;
import java.util.Optional;

public interface ICustomerService {

    Optional<CustomerDto> findById(String carId);
    Optional<CustomerDto> findByEmail(String email);
    Optional<CustomerDto> update(CustomerDto customerDto);
    List<CustomerDto> getAll();
    CustomerPasswordDto save(CustomerDto customerDto);
    boolean delete(String carId);
}
