package com.klashz.api.coches.domain.service.impl;

import com.klashz.api.coches.domain.dto.AuthCustomerDto;
import com.klashz.api.coches.domain.dto.CustomerDto;
import com.klashz.api.coches.domain.dto.JwtResponseDto;
import com.klashz.api.coches.domain.repository.ICustomerRepository;
import com.klashz.api.coches.domain.service.IAuthService;
import com.klashz.api.coches.exception.CustomerNotExistsException;
import com.klashz.api.coches.exception.PasswordIncorrectException;
import com.klashz.api.coches.security.JwtAuthenticationProvider;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService  implements IAuthService {

    private final ICustomerRepository iCustomerRepository;
    /**
     * Administras los jwt tokens
     */
    private final JwtAuthenticationProvider jwtAuthenticationProvider;
    private final PasswordEncoder passwordEncoder;

    public AuthService(ICustomerRepository iCustomerRepository, JwtAuthenticationProvider jwtAuthenticationProvider, PasswordEncoder passwordEncoder) {
        this.iCustomerRepository = iCustomerRepository;
        this.jwtAuthenticationProvider = jwtAuthenticationProvider;
        this.passwordEncoder = passwordEncoder;
    }

    /**
     * Metodo de inicio de session
     * @param authCustomerDto Credenciales de acceso
     * @return Dto con el jwt del usuario si las credenciales son validas
     */
    @Override
    public JwtResponseDto signIn(AuthCustomerDto authCustomerDto) {
        Optional<CustomerDto> customer = iCustomerRepository.getCustomerByEmail(authCustomerDto.getEmail());
        if(customer.isEmpty()){
            throw  new CustomerNotExistsException();
        }
        boolean passwordEquals = passwordEncoder.matches(authCustomerDto.getPassword(),customer.get().getPassword());
        System.out.println("DATOS ");
        System.out.println(passwordEquals);
        System.out.println(authCustomerDto.getPassword());
        System.out.println(customer.get().getPassword());

        if(!passwordEquals){
            throw new PasswordIncorrectException();
        }
        return new JwtResponseDto(jwtAuthenticationProvider.createToken(customer.get()));
    }

    @Override
    public JwtResponseDto signOut(String token) {
        String[] authElements = token.split(" ");
        return new JwtResponseDto(jwtAuthenticationProvider.deleteToken(authElements[1]));
    }
}
