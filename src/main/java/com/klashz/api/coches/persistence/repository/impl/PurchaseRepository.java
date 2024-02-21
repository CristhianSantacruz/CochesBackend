package com.klashz.api.coches.persistence.repository.impl;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.klashz.api.coches.domain.dto.purchases.CarPurchaseResponseDto;
import com.klashz.api.coches.domain.dto.purchases.PurchaseBillResponseDto;
import com.klashz.api.coches.domain.dto.purchases.PurchaseRequestDto;
import com.klashz.api.coches.domain.dto.purchases.PurchaseResponseDto;
import com.klashz.api.coches.domain.repository.IPurchaseRepository;
import com.klashz.api.coches.persistence.mapper.IPurchaseMapper;
import com.klashz.api.coches.persistence.models.PurchaseEntity;
import com.klashz.api.coches.persistence.repository.IPurchaseJpaRepository;
import jdk.swing.interop.SwingInterOpUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class PurchaseRepository implements IPurchaseRepository {

    private final IPurchaseJpaRepository iPurchaseCrudRepository;
    private final IPurchaseMapper iPurchaseMapper;

    public PurchaseRepository(IPurchaseJpaRepository iPurchaseJpaRepository, IPurchaseMapper iPurchaseMapper) {
        this.iPurchaseCrudRepository = iPurchaseJpaRepository;
        this.iPurchaseMapper = iPurchaseMapper;
    }

    @Override
    public List<PurchaseResponseDto> getAll() {

        List<PurchaseEntity> listPurchasesEntity = iPurchaseCrudRepository.findAll();
        List<PurchaseResponseDto> listPurchaseResponseDto = new ArrayList<>();

        listPurchasesEntity.forEach(purchaseEntity -> listPurchaseResponseDto.add(toPurchaseResponseDtoByEntity(purchaseEntity)));

        return listPurchaseResponseDto;
    }

    @Override
    public List<PurchaseResponseDto> getByIdCustomer(String idCustomer) {
        List<PurchaseEntity> listPurchasesEntity = iPurchaseCrudRepository.findAllByCardId(idCustomer);
        List<PurchaseResponseDto> listPurchaseResponseDto = new ArrayList<>();

        listPurchasesEntity.forEach(purchaseEntity -> listPurchaseResponseDto.add(toPurchaseResponseDtoByEntity(purchaseEntity)));

        return listPurchaseResponseDto;
    }

    @Override
    public PurchaseResponseDto getByNumberBill(Long numberBill) {
        Optional<PurchaseEntity> purchaseEntitySearch = iPurchaseCrudRepository.findById(numberBill);

        if(purchaseEntitySearch.isEmpty()) {
            return null;
        }

        return toPurchaseResponseDtoByEntity(purchaseEntitySearch.get());
    }

    @Override
    public PurchaseBillResponseDto save(PurchaseRequestDto purchaseRequestDto) {
        PurchaseEntity purchaseEntity = iPurchaseMapper.toPurchaseEntity(purchaseRequestDto);
        purchaseEntity.getCarPurchases().forEach(carPurchaseEntity -> carPurchaseEntity.setPurchaseEntity(purchaseEntity));
        PurchaseEntity purchaseEntitySave = iPurchaseCrudRepository.save(purchaseEntity);
        return new PurchaseBillResponseDto(purchaseEntitySave.getNumberBill());
    }


    public PurchaseResponseDto toPurchaseResponseDtoByEntity(PurchaseEntity purchaseEntity) {
        PurchaseResponseDto purchaseResponseDto = new PurchaseResponseDto();
        purchaseResponseDto.setNumberBill(purchaseEntity.getNumberBill());
        purchaseResponseDto.setCardId(purchaseEntity.getCardId());
        purchaseResponseDto.setDate(purchaseEntity.getDate());
        purchaseResponseDto.setTotal(purchaseEntity.getTotal());
        purchaseResponseDto.setPaymentMethod(purchaseEntity.getPaymentMethod());
        List<CarPurchaseResponseDto> carPurchaseResponseDtoList = new ArrayList<>();
        purchaseEntity.getCarPurchases().forEach(carPurchaseEntity -> {
            String reference = carPurchaseEntity.getCarEntity().getReference();
            Integer quantity = carPurchaseEntity.getQuantity();
            Double total =  Double.valueOf(carPurchaseEntity.getTotal());
            carPurchaseResponseDtoList.add(new CarPurchaseResponseDto(reference, quantity, total));
        });

        purchaseResponseDto.setCarPurchasesResponses(carPurchaseResponseDtoList);
        return purchaseResponseDto;
    }
}

