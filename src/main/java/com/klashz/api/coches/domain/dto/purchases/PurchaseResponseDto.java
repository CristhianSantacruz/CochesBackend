package com.klashz.api.coches.domain.dto.purchases;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
@Getter
@Setter
public class PurchaseResponseDto {

    @Override
    public String toString() {
        return "PurchaseResponseDto{" +
                "numberBill=" + numberBill +
                ", cardId='" + cardId + '\'' +
                ", date=" + date +
                ", total=" + total +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", carPurchasesResponses=" + carPurchasesResponses +
                '}';
    }

    private Long numberBill;
    private String cardId;
    private LocalDateTime date;
    private Double total;
    private String paymentMethod;
    private List<CarPurchaseResponseDto> carPurchasesResponses;
}
