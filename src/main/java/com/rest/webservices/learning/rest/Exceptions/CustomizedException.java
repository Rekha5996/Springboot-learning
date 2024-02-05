package com.rest.webservices.learning.rest.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDate;

@ControllerAdvice
public class CustomizedException extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ErrorDetails> handleExceptions(Exception ex, WebRequest request) {
        ErrorDetails errdet = new ErrorDetails(LocalDate.now(),
                ex.getMessage(), request.getDescription(false));
        return new ResponseEntity(errdet, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public final ResponseEntity<ErrorDetails> handleUserNotFoundException(Exception ex, WebRequest req){
        ErrorDetails errdetails = new ErrorDetails(LocalDate.now(),ex.getMessage(),req.getDescription(false));
        return  new ResponseEntity(errdetails,HttpStatus.NOT_FOUND);
    }

}
