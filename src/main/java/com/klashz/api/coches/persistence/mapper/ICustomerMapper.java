package com.klashz.api.coches.persistence.mapper;

import com.klashz.api.coches.domain.dto.CustomerDto;
import com.klashz.api.coches.domain.dto.CustomerPasswordDto;
import com.klashz.api.coches.persistence.models.CustomerEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ICustomerMapper {



    CustomerDto toCustomerDto(CustomerEntity customerEntity);
    CustomerEntity toCustomerEntity(CustomerDto customerDto);

    List<CustomerDto>  toCustomersDto(List<CustomerEntity> customerEntities);
}
