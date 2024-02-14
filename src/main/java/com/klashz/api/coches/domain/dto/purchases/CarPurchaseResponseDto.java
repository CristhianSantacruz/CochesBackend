package com.klashz.api.coches.domain.dto.purchases;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CarPurchaseResponseDto {

    private String referenceCar;
    private Integer quantity;
    private Double total;
}


