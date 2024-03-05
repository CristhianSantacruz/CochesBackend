package com.klashz.api.coches.persistence.repository;

import com.klashz.api.coches.persistence.models.PurchaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IPurchaseJpaRepository extends JpaRepository<PurchaseEntity, Long> {


    List<PurchaseEntity> findAllByCardId(String id);

}
