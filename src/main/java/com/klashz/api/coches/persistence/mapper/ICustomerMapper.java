package com.klashz.api.coches.persistence.mapper;

import com.klashz.api.coches.domain.dto.CustomerDto;
import com.klashz.api.coches.persistence.models.CustomerEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ICustomerMapper {



    CustomerDto toCustomerDto(CustomerEntity customerEntity);
    @Mapping(target="purchaseEntityList", ignore = true)
    CustomerEntity toCustomerEntity(CustomerDto customerDto);

    List<CustomerDto>  toCustomersDto(List<CustomerEntity> customerEntities);
}
