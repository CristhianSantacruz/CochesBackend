package com.klashz.api.coches.domain.repository;

import com.klashz.api.coches.domain.dto.BrandCarDto;
import com.klashz.api.coches.domain.dto.purchases.PurchaseBillResponseDto;
import com.klashz.api.coches.domain.dto.purchases.PurchaseRequestDto;
import com.klashz.api.coches.domain.dto.purchases.PurchaseResponseDto;

import java.util.List;
import java.util.Optional;

public interface IPurchaseRepository {

    List<PurchaseResponseDto> getAll();
    List<PurchaseResponseDto> getByIdCustomer(String idCustomer);
    PurchaseResponseDto getByNumberBill(Long numberBill);
    PurchaseBillResponseDto save(PurchaseRequestDto purchaseRequestDto);
}
