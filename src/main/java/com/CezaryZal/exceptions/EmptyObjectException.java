package com.CezaryZal.exceptions;

public class EmptyObjectException extends RuntimeException {

    public EmptyObjectException(String exceptionDescription) {
        super(exceptionDescription);
    }
}
