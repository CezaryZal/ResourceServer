package com.CezaryZal.exceptions;

public class IncorrectInputException extends RuntimeException {

    public IncorrectInputException(String exceptionDescription) {
        super(exceptionDescription);
    }
}
