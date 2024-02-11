package com.klashz.api.coches.persistence.repository;

import com.klashz.api.coches.persistence.models.MarcaCocheEntity;
import org.springframework.data.jpa.repository.JpaRepository;



public interface IMarcaCocheJpaRespository extends JpaRepository<MarcaCocheEntity,Long> {
}
