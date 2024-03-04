package com.klashz.api.coches.domain.dto.purchases;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CarPurchaseRequestDto {

    private Long purchaseNumberBill;
    private Long codeCar;
    private Integer quantity;
    private Double total;
}
