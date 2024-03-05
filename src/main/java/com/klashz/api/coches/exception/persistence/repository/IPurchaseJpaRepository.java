package com.klashz.api.coches.exception.persistence.repository;

import com.klashz.api.coches.exception.persistence.models.PurchaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IPurchaseJpaRepository extends JpaRepository<PurchaseEntity, Long> {


    List<PurchaseEntity> findAllByCardId(String id);

}
