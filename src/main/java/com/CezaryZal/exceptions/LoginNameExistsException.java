package com.CezaryZal.exceptions;

public class LoginNameExistsException extends RuntimeException {

    public LoginNameExistsException(String exceptionDescription) {
        super(exceptionDescription);
    }
}
