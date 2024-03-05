package com.klashz.api.coches.exception.persistence.repository;

import com.klashz.api.coches.exception.persistence.models.BrandCarEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBrandJpaRepository extends JpaRepository<BrandCarEntity, Long> {
}
