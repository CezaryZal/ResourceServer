package com.CezaryZal.exceptions;

public class IncorrectInput extends RuntimeException {

    public IncorrectInput(String exceptionDescription) {
        super(exceptionDescription);
    }
}
