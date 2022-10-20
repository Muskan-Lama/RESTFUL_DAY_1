package com.TTN.spring.quetion2to9;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

public class CustomizedResponseEntityExceptionHandler {

    /** Exception Handler for custom exception that I have created ***/
    @ExceptionHandler(IdNotFoundException.class)
    public final ResponseEntity<ErrorShow> handleEmployeeNotFoundException(Exception ex, WebRequest request){
        ErrorShow errorDetail = new ErrorShow(
                ex.getMessage(),
                request.getDescription(false)
        );
        return new ResponseEntity<ErrorShow>(errorDetail, HttpStatus.NOT_FOUND);
    }


}
