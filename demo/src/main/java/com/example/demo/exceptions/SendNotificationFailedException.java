package com.example.demo.exceptions;

public class SendNotificationFailedException extends NonRetryableException {

    private static final long serialVersionUID = 1L;

    public SendNotificationFailedException(String message) {
        super(message);
    }
}
