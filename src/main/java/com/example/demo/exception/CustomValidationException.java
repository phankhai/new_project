package com.example.demo.exception;

import org.springframework.validation.BindException;

public class CustomValidationException extends Exception{

    private BindException bindException;

    public CustomValidationException(BindException errors) {
        this.bindException = errors;
    }

    public BindException getBindException() {
        return bindException;
    }

    public void setBindException(BindException bindException) {
        this.bindException = bindException;
    }
}
