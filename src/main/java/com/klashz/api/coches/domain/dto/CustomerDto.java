package com.klashz.api.coches.domain.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Dto para la entidad Cliente
 */
@Getter
@Setter
@ToString
public class CustomerDto {


    private String cardId;

    private Integer active;

    private String email;

    private String  fullName;

    private String  phone;

    private String password;

    private String rol;
}
