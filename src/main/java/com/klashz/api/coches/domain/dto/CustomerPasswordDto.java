package com.klashz.api.coches.domain.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
@Builder
@Getter
@Setter
public class CustomerPasswordDto {

    private String cardId;
    private String password;
}
