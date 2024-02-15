package com.klashz.api.coches.domain.service.impl;

import com.klashz.api.coches.domain.dto.CustomerDto;
import com.klashz.api.coches.domain.dto.CustomerPasswordDto;
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
    public Optional<CustomerDto> findById(String carId) {
        return iCustomerRepository.findById(carId);
    }

    @Override
    public Optional<CustomerDto> findByEmail(String email) {
        return iCustomerRepository.findByEmail(email);
    }

    @Override
    public Optional<CustomerDto> update(CustomerDto customerDto) {
        if(iCustomerRepository.findById(customerDto.getCarId()).isEmpty()){
            return Optional.empty();
        }
        return Optional.of(iCustomerRepository.save(customerDto));
    }

    @Override
    public List<CustomerDto> getAll() {
        return iCustomerRepository.getAll();
    }

    @Override
    public CustomerPasswordDto save(CustomerDto customerDto) {

        if(!customerDto.getEmail().matches("^[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?$")){
            throw new EmailException();
        }

        boolean emailPresentDataBase  = findByEmail(customerDto.getEmail()).isPresent();
        boolean idPresentDataBase = findById(customerDto.getCarId()).isPresent();


        if(idPresentDataBase || emailPresentDataBase){
            throw  new CustomerExitsException();
        }
        String passwordGenerated = generatePassword(10);
        customerDto.setRol(Roles.USER);
        customerDto.setPassword(passwordEncoder.encode(passwordGenerated));
        customerDto.setActive(1);
        iCustomerRepository.save(customerDto);
        return CustomerPasswordDto.builder()
                .cardId(customerDto.getCarId())
                .password(passwordGenerated)
                .build();
    }

    @Override
    public boolean delete(String carId) {
        if(iCustomerRepository.findById(carId).isEmpty()){
            return false;
        }
        iCustomerRepository.delete(carId);
        return true;
    }

    private String generatePassword(int len){
        final String chars = "ABCDEFGHIJKLMNOPQRSTUVRXYWZabcdefghijklmnopqrstuvxwyz1234567890";
        StringBuilder sb = new StringBuilder();
        SecureRandom random = new SecureRandom();
        for(int i = 0 ; i< len ; i++ ){
            int randomIndex= random.nextInt(chars.length());
            sb.append(chars.charAt(randomIndex));
        }
        return sb.toString();
    }
}
