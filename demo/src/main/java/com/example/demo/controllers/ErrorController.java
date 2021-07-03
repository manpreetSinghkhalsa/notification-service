package com.example.demo.controllers;

import com.example.demo.dtos.GenericErrorResponse;
import com.example.demo.exceptions.BadRequestException;
import com.example.demo.exceptions.MissingIdException;
import com.example.demo.exceptions.NonRetryableException;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.commons.lang.StringEscapeUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ErrorController {
    // TODO: handle notifcationSendException
    @ExceptionHandler(value = { BadRequestException.class, MissingIdException.class })
    @ResponseBody
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public final Object handleBadRequestException(NonRetryableException exception, HttpServletRequest servletRequest) {
        return errorResponseForException(exception, exception.getErrorCode(), servletRequest);
    }

    protected Object errorResponseForException(Exception exception, int errorCode, HttpServletRequest servletRequest) {
        String message = StringEscapeUtils.escapeHtml(exception.getMessage());
        return GenericErrorResponse.from(errorCode, message);
    }

    @ExceptionHandler(value = { HttpMessageNotReadableException.class })
    @ResponseBody
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public final Object handleHttpMessageNotReadableException(Exception exception, HttpServletRequest servletRequest) {

        String message = errorMessageForJsonParseException(exception);
        message = decorateMessage(message, exception);

        return errorResponseForMessage(message, servletRequest);
    }

    private Object errorResponseForMessage(String message, HttpServletRequest servletRequest) {
        int errorCode = GenericErrorResponse.ERROR_GENERIC;
        return GenericErrorResponse.from(errorCode, message);
    }

    private static String errorMessageForJsonParseException(Exception exception) {

        Throwable cause = causedBy(exception);
        if (cause == null) {
            return null;
        }

        if (cause instanceof JsonProcessingException) {
            return "Json is not in valid format";
        }

        return null;
    }

    private static String decorateMessage(String message, Exception exception) {

        if (message != null) {
            return StringEscapeUtils.escapeHtml(message);
        }

        message = exception.getMessage();
        return StringEscapeUtils.escapeHtml(message);
    }

    private static Throwable causedBy(Throwable throwable) {

        Throwable cause = throwable.getCause();
        while (cause != null) {
            throwable = cause;
            cause = throwable.getCause();
        }

        return throwable;
    }
}