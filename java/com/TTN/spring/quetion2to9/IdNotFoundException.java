package com.TTN.spring.quetion2to9;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;


//using this annotation we throw error code =404
@ResponseStatus(code= HttpStatus.NOT_FOUND)
public class IdNotFoundException extends RuntimeException {

    public IdNotFoundException(String message)
    {
        super(message);
    }



}
