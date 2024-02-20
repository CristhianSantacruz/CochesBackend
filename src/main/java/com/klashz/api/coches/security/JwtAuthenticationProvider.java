package com.klashz.api.coches.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import com.klashz.api.coches.domain.dto.CustomerDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;

@Component
public class JwtAuthenticationProvider {

    /**
     * Llave para cifrar el jwt
     */
    @Value("${jwt.secret.key}")
    private String secretKey;

    /**
     * Lista blanca con los jwt creados
     */
    private HashMap<String, CustomerDto> listToken = new HashMap<>();

    public String createToken(CustomerDto customerJwt) {
        Date now = new Date();
        Date validity = new Date(now.getTime() +  3600000);
        Algorithm algorithm = Algorithm.HMAC256(secretKey);
        String tokenCreated = JWT.create()
                .withClaim("carId",customerJwt.getCarId())
                .withClaim("fullname",customerJwt.getFullName())
                .withClaim("numberCellPhone",customerJwt.getPhone())
                .withClaim("email",customerJwt.getEmail())
                .withClaim("rol",customerJwt.getRol())
                .withIssuedAt(now)
                .withExpiresAt(validity)
                .sign(algorithm);
        listToken.put(tokenCreated,customerJwt);
        return tokenCreated;
    }
    /**
     * Valida si el token es valido y retorna una sesión del usuario
     * @param token Token a validar
     * @return Sesion del usuario
     * @throws CredentialsExpiredException Si el token ya expiró
     * @throws BadCredentialsException Si el token no existe en la lista blanca
     */
    public Authentication validateToken(String token) throws AuthenticationException {

        System.out.println("entre tambien aqui");
        System.out.println(token);

        //verifica el token como su firma y expiración, lanza una excepcion si algo falla
        JWT.require(Algorithm.HMAC256(secretKey)).build().verify(token);


        CustomerDto exists = listToken.get(token);
        if (exists == null) {
            throw new BadCredentialsException("Usuario no registrado.");
        }

        HashSet<SimpleGrantedAuthority> rolesAndAuthorities = new HashSet<>();
        rolesAndAuthorities.add(new SimpleGrantedAuthority("ROLE_"+exists.getRol())); //rol
        // rolesAndAuthorities.add(new SimpleGrantedAuthority("ELIMINAR_PRIVILEGE")); // permisos del rol


        return new UsernamePasswordAuthenticationToken(exists, token, rolesAndAuthorities);
    }

    public String deleteToken(String jwt) {

        if (!listToken.containsKey(jwt)) {
            return "No existe token";
        }

        listToken.remove(jwt);
        return "Sesión cerrada exitosamente";
    }
}
