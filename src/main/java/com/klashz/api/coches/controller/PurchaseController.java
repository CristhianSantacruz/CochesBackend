package com.klashz.api.coches.controller;

import com.klashz.api.coches.domain.dto.purchases.PurchaseBillResponseDto;
import com.klashz.api.coches.domain.dto.purchases.PurchaseRequestDto;
import com.klashz.api.coches.domain.dto.purchases.PurchaseResponseDto;
import com.klashz.api.coches.domain.service.IPurchaseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/purchases")
public class PurchaseController {

    private final IPurchaseService iPurchaseService;
    public PurchaseController(IPurchaseService iPurchaseService) {
        this.iPurchaseService = iPurchaseService;
    }
    @GetMapping()
    public ResponseEntity<List<PurchaseResponseDto>> getAll(){
        return ResponseEntity.ok(iPurchaseService.getAll());
    }
    @GetMapping("/customers/{cardId}")
    public ResponseEntity<List<PurchaseResponseDto>> getAllCustomers(@PathVariable String cardId){
        return ResponseEntity.ok(iPurchaseService.getByIdCustomer(cardId));
    }
    @GetMapping("/{numberBill}")
    public ResponseEntity<PurchaseResponseDto> getPurchasesByNumberBill(
            @PathVariable Long numberBill){
        return ResponseEntity.ok(iPurchaseService.getByNumberBill(numberBill));
    }
    @PostMapping()
    public ResponseEntity<PurchaseBillResponseDto> savePurchase(@RequestBody PurchaseRequestDto purchaseRequestDto){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(iPurchaseService.save(purchaseRequestDto));
    }

}
