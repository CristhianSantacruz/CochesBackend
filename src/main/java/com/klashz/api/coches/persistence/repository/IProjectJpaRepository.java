package com.klashz.api.coches.persistence.repository;

import com.klashz.api.coches.persistence.models.ProjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProjectJpaRepository extends JpaRepository<ProjectEntity,Long> {
}
