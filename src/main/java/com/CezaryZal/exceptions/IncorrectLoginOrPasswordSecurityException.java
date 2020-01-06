package com.CezaryZal.exceptions;

public class IncorrectLoginOrPasswordSecurityException extends RuntimeException {

    public IncorrectLoginOrPasswordSecurityException(String exceptionDescription) {
        super(exceptionDescription);
    }
}
