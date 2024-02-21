package com.klashz.api.coches.controller;

import com.klashz.api.coches.domain.dto.*;
import com.klashz.api.coches.domain.service.IAuthService;
import com.klashz.api.coches.domain.service.ICustomerService;
import com.klashz.api.coches.domain.service.impl.CustomerService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/auth")
public class AuthController {

    private final IAuthService   authService;
    private final ICustomerService iCustomerService;
    public AuthController(IAuthService authService, CustomerService iCustomerService) {
        this.authService = authService;

        this.iCustomerService = iCustomerService;
    }
    @PostMapping(path = "/register")
    public ResponseEntity<ResponseCustomerDto> save(@RequestBody CustomerDto customerDtoNew) {
        return ResponseEntity.ok(iCustomerService.save(customerDtoNew));
    }

    @PostMapping("/sign-in")
    public ResponseEntity<JwtResponseDto> singIn(@RequestBody AuthCustomerDto authCustomerDto){
        return ResponseEntity.ok(authService.signIn(authCustomerDto));
    }
    @PostMapping("/sign-out")
    public ResponseEntity<JwtResponseDto> singOut(@RequestHeader(name = HttpHeaders.AUTHORIZATION)String jwt){
        return ResponseEntity.ok(authService.signOut(jwt));
    }
}
