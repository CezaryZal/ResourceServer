package com.CezaryZal.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    //Stowrzyć obiekt do obsługi wyjątków żeby wyświetlić np. nazwę błędu (klasy)
    @ExceptionHandler({
            NullInputException.class,
            EmptyObjectException.class,
            ToShortStringException.class,})
    protected ResponseEntity<Object> handleValidationLoginAndPasswordExceptions(RuntimeException ex, WebRequest request) {
        return handleExceptionInternal(ex, ex.getMessage(), new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

    @ExceptionHandler({IncorrectLoginOrPasswordSecurityException.class})
    protected ResponseEntity<Object> handleLoginExceptions(RuntimeException ex, WebRequest request) {
        return handleExceptionInternal(ex, ex.getMessage(), new HttpHeaders(), HttpStatus.FORBIDDEN, request);
    }



}
