package com.example.demo.exceptions;

import lombok.Getter;

@Getter
public class NonRetryableException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    private static final int ERROR_GENERIC = -1;
    private final int errorCode;

    public NonRetryableException() {
        this(ERROR_GENERIC);
    }

    public NonRetryableException(int errorCode) {
        super();
        this.errorCode = errorCode;
    }

    public NonRetryableException(String message) {
        this(message, ERROR_GENERIC);
    }

    public NonRetryableException(String message, int errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
}
