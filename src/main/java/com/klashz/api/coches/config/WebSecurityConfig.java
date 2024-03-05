package com.klashz.api.coches.config;

import com.klashz.api.coches.exception.AccessDeniedHandlerException;
import com.klashz.api.coches.security.JwtAuthFilter;
import com.klashz.api.coches.security.Roles;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;
import java.util.List;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    private final AccessDeniedHandlerException accessDeniedHandlerException;
    private final JwtAuthFilter jwtAuthFilter;

    public WebSecurityConfig(AccessDeniedHandlerException accessDeniedHandlerException, JwtAuthFilter jwtAuthFilter) {
        this.accessDeniedHandlerException = accessDeniedHandlerException;
        this.jwtAuthFilter = jwtAuthFilter;
    }


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .cors(withDefaults())
                .exceptionHandling(exception -> exception.accessDeniedHandler(accessDeniedHandlerException))
                .csrf(crf -> crf.disable())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
                .authorizeHttpRequests(requests ->
                        requests
                                .requestMatchers("/auth/**", "/swagger-ui.html", "/swagger-ui/**", "/v3/api-docs/**","/marca").permitAll()
                                .requestMatchers(HttpMethod.GET, "/customer/**").hasAnyRole(Roles.USER, Roles.ADMIN)
                                .requestMatchers(HttpMethod.DELETE, "/customer/**").hasRole(Roles.ADMIN)
                                .requestMatchers(HttpMethod.DELETE, "/car/**").hasRole(Roles.ADMIN)
                                .requestMatchers(HttpMethod.DELETE, "/marca/**").hasRole(Roles.ADMIN)
                                .requestMatchers(HttpMethod.GET,"/car/**").hasAnyRole(Roles.USER, Roles.ADMIN)
                                .requestMatchers(HttpMethod.POST, "/car/**").hasRole(Roles.ADMIN)
                                .requestMatchers(HttpMethod.POST,"/project/**").hasAnyRole(Roles.ADMIN)
                                .anyRequest().authenticated()

                );


        return http.build();
    }
    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList(CorsConfiguration.ALL));
        configuration.setAllowedMethods(Arrays.asList(CorsConfiguration.ALL));
        configuration.setAllowedHeaders(Arrays.asList(CorsConfiguration.ALL));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}
