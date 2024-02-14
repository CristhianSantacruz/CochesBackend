package com.klashz.api.coches.domain.service;

import com.klashz.api.coches.domain.dto.purchases.PurchaseBillResponseDto;
import com.klashz.api.coches.domain.dto.purchases.PurchaseRequestDto;
import com.klashz.api.coches.domain.dto.purchases.PurchaseResponseDto;

import java.util.List;

public interface IPurchaseService {

    List<PurchaseResponseDto> getAll();

    List<PurchaseResponseDto> getByIdCustomer(String idCustomer);

    PurchaseResponseDto getByNumberBill(Long numberBill);

    PurchaseBillResponseDto save(PurchaseRequestDto purchaseRequestDto);
}
