package com.klashz.api.coches.domain.dto.purchases;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class CarPurchaseResponseDto {

    private String referenceCar;
    private Integer quantity;
    private Double total;


    public CarPurchaseResponseDto(String referenceCar, Integer quantity, Double total){
        this.referenceCar = referenceCar;
        this.quantity = quantity;
        this.total = total;
    }

    @Override
    public String toString() {
        return "CarPurchaseResponseDto{" +
                "referenceCar='" + referenceCar + '\'' +
                ", quantity=" + quantity +
                ", total=" + total +
                '}';
    }
}


