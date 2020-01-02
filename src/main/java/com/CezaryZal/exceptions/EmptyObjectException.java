package com.CezaryZal.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class EmptyObjectException extends RuntimeException {

    public EmptyObjectException(String exceptionDescription) {
        super(exceptionDescription);
    }
}
