package com.klashz.api.coches.domain.service.impl;

import com.klashz.api.coches.domain.dto.CarDto;
import com.klashz.api.coches.domain.dto.purchases.PurchaseBillResponseDto;
import com.klashz.api.coches.domain.dto.purchases.PurchaseRequestDto;
import com.klashz.api.coches.domain.dto.purchases.PurchaseResponseDto;
import com.klashz.api.coches.domain.repository.ICarRepository;
import com.klashz.api.coches.domain.repository.IPurchaseRepository;
import com.klashz.api.coches.domain.service.IPurchaseService;
import com.klashz.api.coches.exception.EmailException;
import com.klashz.api.coches.exception.PurchaseNotExistException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseService  implements IPurchaseService {

    private final IPurchaseRepository iPurchaseRepository;
    private final ICarRepository iCarRepository;

    public PurchaseService(IPurchaseRepository iPurchaseRepository, ICarRepository iCarRepository) {
        this.iPurchaseRepository = iPurchaseRepository;
        this.iCarRepository = iCarRepository;
    }

    @Override
    public List<PurchaseResponseDto> getAll() {
        return iPurchaseRepository.getAll();
    }

    @Override
    public List<PurchaseResponseDto> getByIdCustomer(String idCustomer) {
        return iPurchaseRepository.getByIdCustomer(idCustomer);
    }

    @Override
    public PurchaseResponseDto getByNumberBill(Long numberBill) {
        PurchaseResponseDto purchaseResponseDto = iPurchaseRepository.getByNumberBill(numberBill);

        if (purchaseResponseDto == null) {
            throw new PurchaseNotExistException();
        }

        return purchaseResponseDto;
    }

    @Override
    public PurchaseBillResponseDto save(PurchaseRequestDto purchaseRequestDto) {
        PurchaseBillResponseDto billResponseDto = iPurchaseRepository.save(purchaseRequestDto);

        purchaseRequestDto.getCarPurchases().forEach(carPurchase -> {
            CarDto carActual = iCarRepository.findById(carPurchase.getCodeCar()).get();

            carActual.setStock(carActual.getStock() - carPurchase.getQuantityCar());

            iCarRepository.save(carActual);
        });

        return billResponseDto;
    }
}