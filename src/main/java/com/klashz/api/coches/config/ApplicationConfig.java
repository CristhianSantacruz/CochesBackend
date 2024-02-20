package com.klashz.api.coches.config;

/* */
import com.klashz.api.coches.security.JwtAuthFilter;
import com.klashz.api.coches.security.JwtAuthenticationProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Clase de configuración para la creación de Beans a utilizar
 */

@Configuration
public class ApplicationConfig {

    private final JwtAuthenticationProvider jwtAuthenticationProvider;

    public ApplicationConfig(JwtAuthenticationProvider jwtAuthenticationProvider) {
        this.jwtAuthenticationProvider = jwtAuthenticationProvider;
    }

    /**
     * Bean de Password Encoder para inyeccion
     * @return Implemetación BCryptPasswordEncoder
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * Bean de JwtAuthFilter para inyeccion
     * @return Implementación JwtAuthFilter
     */
    @Bean
    public JwtAuthFilter jwtAuthFilter() {
        return new JwtAuthFilter(jwtAuthenticationProvider);
    }

}

