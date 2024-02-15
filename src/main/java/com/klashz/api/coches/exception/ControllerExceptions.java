package com.klashz.api.coches.exception;


import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerExceptions {

    @ExceptionHandler({EmailException.class ,
            PurchaseNotExistException.class,
            CustomerNotExistsException.class,
            CustomerExitsException.class,
            PasswordIncorrectException.class})
    public ProblemDetail customerNotExits(RuntimeException runtimeException){
        return ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST,
                runtimeException.getMessage());
    }

    @ExceptionHandler({UnauthorizedException.class, AuthenticationException.class, JWTVerificationException.class})
    public ProblemDetail unauthorizedException(AuthenticationException authenticationException) {
        return ProblemDetail.forStatusAndDetail(HttpStatus.UNAUTHORIZED, authenticationException.getMessage());
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ProblemDetail accessDeniedException(AccessDeniedException accessDeniedException){
        return ProblemDetail.forStatusAndDetail(HttpStatus.UNAUTHORIZED,accessDeniedException.getMessage());
    }
}
