package com.klashz.api.coches.domain.service.impl;

import com.klashz.api.coches.domain.dto.CustomerDto;
import com.klashz.api.coches.domain.dto.CustomerPasswordDto;
import com.klashz.api.coches.domain.dto.ResponseCustomerDto;
import com.klashz.api.coches.domain.repository.ICustomerRepository;
import com.klashz.api.coches.domain.service.ICustomerService;
import com.klashz.api.coches.exception.CustomerExitsException;
import com.klashz.api.coches.exception.EmailException;
import com.klashz.api.coches.security.Roles;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.List;
import java.util.Optional;
@Service
public class CustomerService implements ICustomerService {

    private final ICustomerRepository iCustomerRepository;
    private final PasswordEncoder passwordEncoder;

    public CustomerService(ICustomerRepository iCustomerRepository, PasswordEncoder passwordEncoder) {
        this.iCustomerRepository = iCustomerRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Optional<CustomerDto> getCustomerByCardId(String carId) {
        return iCustomerRepository.getCustomerByCardId(carId);
    }

    @Override
    public Optional<CustomerDto> getCustomerByEmail(String email) {
        return iCustomerRepository.getCustomerByEmail(email);
    }



    @Override
    public List<CustomerDto> getAll() {
        return iCustomerRepository.getAll();
    }

    @Override
    public ResponseCustomerDto save(CustomerDto newCustomer) {

        if (!newCustomer.getEmail().matches("^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
                + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$")) {
            throw new EmailException();
        }

        if (getCustomerByCardId(newCustomer.getCardId()).isPresent() || getCustomerByEmail(newCustomer.getEmail()).isPresent()) {
            throw new CustomerExitsException();
        }
        String passwordUser = newCustomer.getPassword();
        newCustomer.setPassword(passwordEncoder.encode(passwordUser));
        newCustomer.setActive(1);
        newCustomer.setRol(Roles.USER);
        iCustomerRepository.save(newCustomer);

        return new ResponseCustomerDto(newCustomer.getFullName());
    }
    @Override
    public Optional<CustomerDto> update(CustomerDto updateCustomerDto) {
        if(iCustomerRepository.getCustomerByCardId(updateCustomerDto.getCardId()).isEmpty()){
            return Optional.empty();
        }
        String passwordUser = updateCustomerDto.getPassword();
        updateCustomerDto.setPassword(passwordEncoder.encode(passwordUser));
        return Optional.of(iCustomerRepository.save(updateCustomerDto));
    }

    @Override
    public boolean delete(String carId) {
        if(iCustomerRepository.getCustomerByCardId(carId).isEmpty()){
            return false;
        }
        iCustomerRepository.delete(carId);
        return true;
    }

}
