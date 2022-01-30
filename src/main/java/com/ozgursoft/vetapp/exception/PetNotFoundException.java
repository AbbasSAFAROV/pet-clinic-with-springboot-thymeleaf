package com.ozgursoft.vetapp.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class PetNotFoundException extends RuntimeException{

    public PetNotFoundException(String message) {
        super(message);
    }
}
