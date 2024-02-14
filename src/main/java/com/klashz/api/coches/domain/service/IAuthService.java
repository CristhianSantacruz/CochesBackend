package com.klashz.api.coches.domain.service;

import com.klashz.api.coches.domain.dto.AuthCustomerDto;
import com.klashz.api.coches.domain.dto.JwtResponseDto;

public interface IAuthService {

    JwtResponseDto signIn(AuthCustomerDto authCustomerDto);
    JwtResponseDto signOut(String jwt);
}
