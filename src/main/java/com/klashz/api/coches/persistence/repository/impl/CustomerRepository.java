package com.klashz.api.coches.persistence.repository.impl;

import com.klashz.api.coches.domain.dto.CustomerDto;
import com.klashz.api.coches.domain.repository.ICustomerRepository;
import com.klashz.api.coches.persistence.mapper.ICustomerMapper;
import com.klashz.api.coches.persistence.models.CustomerEntity;
import com.klashz.api.coches.persistence.repository.ICustomerJpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CustomerRepository  implements ICustomerRepository {

    private final ICustomerMapper iCustomerMapper;
    private final ICustomerJpaRepository iCustomerJpaRepository;

    public CustomerRepository(ICustomerMapper iCustomerMapper, ICustomerJpaRepository iCustomerJpaRepository) {
        this.iCustomerMapper = iCustomerMapper;
        this.iCustomerJpaRepository = iCustomerJpaRepository;
    }


    @Override
    public Optional<CustomerDto> findById(String carId) {
        return iCustomerJpaRepository.findById(carId)
                .map(iCustomerMapper::toCustomerDto);
    }

    @Override
    public Optional<CustomerDto> findByEmail(String email) {
        return iCustomerJpaRepository.findByEmail(email)
                .map(iCustomerMapper::toCustomerDto);
    }

    @Override
    public List<CustomerDto> getAll() {
        return iCustomerMapper.toCustomersDto(iCustomerJpaRepository.findAll());
    }

    @Override
    public CustomerDto save(CustomerDto customerDto) {
        CustomerEntity customerEntity = iCustomerMapper.toCustomerEntity(customerDto);
        return iCustomerMapper.toCustomerDto(iCustomerJpaRepository.save(customerEntity));
    }

    @Override
    public void delete(String carId) {
        iCustomerJpaRepository.deleteById(carId);
    }
}
