package com.klashz.api.coches.domain.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseCustomerDto {
    private String  userName;

    public ResponseCustomerDto(String userName) {
        this.userName= userName;
    }
}
