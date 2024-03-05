package com.klashz.api.coches.persistence.repository;

import com.klashz.api.coches.persistence.models.BrandCarEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBrandJpaRepository extends JpaRepository<BrandCarEntity, Long> {
}
