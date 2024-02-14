package com.klashz.api.coches.security;

public class JwtAuthFilter {

    private final JwtAuthenticationProvider jwtAuthenticationProvider;

    public JwtAuthFilter(JwtAuthenticationProvider jwtAuthenticationProvider) {
        this.jwtAuthenticationProvider = jwtAuthenticationProvider;
    }
}
