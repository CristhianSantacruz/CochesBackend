package com.klashz.api.coches.controller;

import com.klashz.api.coches.domain.dto.AuthCustomerDto;
import com.klashz.api.coches.domain.dto.JwtResponseDto;
import com.klashz.api.coches.domain.service.AuthService;
import com.klashz.api.coches.domain.service.IAuthService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final IAuthService authService;

    public AuthController(IAuthService authService) {
        this.authService = authService;
    }

    @GetMapping("/sign-in")
    public ResponseEntity<JwtResponseDto> singIn(@RequestBody AuthCustomerDto authCustomerDto){
        return ResponseEntity.ok(authService.signIn(authCustomerDto));
    }
    @GetMapping("/sign-out")
    public ResponseEntity<JwtResponseDto> singOut(@RequestHeader(name = HttpHeaders.AUTHORIZATION)String jwt){
        return ResponseEntity.ok(authService.signOut(jwt));
    }
}
