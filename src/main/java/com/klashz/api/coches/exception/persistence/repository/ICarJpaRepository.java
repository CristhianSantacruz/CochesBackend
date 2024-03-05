package com.klashz.api.coches.exception.persistence.repository;

import com.klashz.api.coches.exception.persistence.models.CarEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ICarJpaRepository extends JpaRepository<CarEntity,Long> {


    @Query("select c from CarEntity  c where  c.branCardId = ?1")
    List<CarEntity> findAllByBrandCarId(Long brandId);

    List<CarEntity> findAllByPriceLessThanOrderByPriceDesc(Double price);
}
