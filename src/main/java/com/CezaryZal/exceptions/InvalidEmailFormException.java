package com.CezaryZal.exceptions;

public class InvalidEmailFormException extends RuntimeException {

    public InvalidEmailFormException(String exceptionDescription) {
        super(exceptionDescription);
    }
}
