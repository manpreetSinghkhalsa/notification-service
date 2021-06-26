package com.example.demo.exceptions;

public class BadRequestException extends NonRetryableException {

    private static final long serialVersionUID = 1L;

    public BadRequestException(String message) {
        super(message);
    }

}
