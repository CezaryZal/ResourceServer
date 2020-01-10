package com.CezaryZal.exceptions;

public class IncorrectRoleException extends RuntimeException{

    public IncorrectRoleException(String exceptionDescription) {
        super(exceptionDescription);
    }
}
