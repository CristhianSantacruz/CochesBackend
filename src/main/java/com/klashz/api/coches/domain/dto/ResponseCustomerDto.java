package com.klashz.api.coches.domain.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseCustomerDto {
    private String passwordGenerated;

    public ResponseCustomerDto(String passwordGenerated) {
        this.passwordGenerated = passwordGenerated;
    }
}
