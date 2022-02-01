package com.ozgursoft.vetapp.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class RoleNoFoundException extends RuntimeException{

    public RoleNoFoundException(String message) {
        super(message);
    }
}
