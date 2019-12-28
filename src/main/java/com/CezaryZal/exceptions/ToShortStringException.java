package com.CezaryZal.exceptions;

public class ToShortStringException extends RuntimeException {

    public ToShortStringException(String exceptionDescription) {
        super(exceptionDescription);
    }
}
