package com.klashz.api.coches.exception.persistence.repository;

import com.klashz.api.coches.exception.persistence.models.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ICustomerJpaRepository extends JpaRepository<CustomerEntity,String> {


    Optional<CustomerEntity> findByEmail(String email);
}
