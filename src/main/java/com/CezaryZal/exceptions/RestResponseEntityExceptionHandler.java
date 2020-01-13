package com.CezaryZal.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.security.auth.login.AccountNotFoundException;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    //Stowrzyć obiekt do obsługi wyjątków żeby wyświetlić np. nazwę błędu (klasy)
    @ExceptionHandler({
            NullInputException.class,
            EmptyObjectException.class,
            ToShortStringException.class,
            IncorrectRoleException.class,
            InvalidEmailFormException.class})
    protected ResponseEntity<Object> handleValidationLoginAndPasswordExceptions(RuntimeException ex, WebRequest request) {
        return handleExceptionInternal(ex, ex.getMessage(), new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

    @ExceptionHandler({IncorrectLoginOrPasswordSecurityException.class})
    protected ResponseEntity<Object> handleLoginExceptions(RuntimeException ex, WebRequest request) {
        return handleExceptionInternal(ex, ex.getMessage(), new HttpHeaders(), HttpStatus.FORBIDDEN, request);
    }

    @ExceptionHandler(LoginNameExistsException.class)
    protected ResponseEntity<Object> handleLoginExistsException(RuntimeException ex, WebRequest request) {
        return handleExceptionInternal(ex, ex.getMessage(), new HttpHeaders(), HttpStatus.CONFLICT, request);
    }

    @ExceptionHandler({
            AccountNotFoundException.class,
            InvalidPasswordException.class})
    protected ResponseEntity<Object> handleInvalidLoginException(RuntimeException ex, WebRequest request) {
        return handleExceptionInternal(ex, "Login or password incorrectly entered", new HttpHeaders(), HttpStatus.FORBIDDEN, request);
    }

}
