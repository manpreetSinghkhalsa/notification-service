package com.example.demo.exceptions;

public class MissingIdException extends NonRetryableException {

    private static final long serialVersionUID = 1L;

    public MissingIdException(String message) {
        super(message);
    }

}
