package com.klashz.api.coches.domain.service;

import com.klashz.api.coches.domain.dto.CustomerDto;
import com.klashz.api.coches.domain.dto.CustomerPasswordDto;
import com.klashz.api.coches.domain.dto.ResponseCustomerDto;

import java.util.List;
import java.util.Optional;

public interface ICustomerService {

    Optional<CustomerDto> getCustomerByCardId(String carId);
    Optional<CustomerDto>  getCustomerByEmail(String email);
    Optional<CustomerDto> update(CustomerDto customerDto);
    List<CustomerDto> getAll();
    ResponseCustomerDto save(CustomerDto customerDto);
    boolean delete(String carId);
}
