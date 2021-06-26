package com.example.demo.validators;

import com.example.demo.dtos.CreateNotificationRequest;
import com.example.demo.enums.NotificationType;
import com.example.demo.exceptions.BadRequestException;
import com.example.demo.exceptions.MissingIdException;

import java.util.Map;

public class DataValidators {

    private static void validate(Integer id, String idName) {
        if (id == null) {
            throw new MissingIdException("Missing " + idName);
        }
    }

    private static void validate(String id, String idName) {
        if (id == null || id.trim().isEmpty() || id.equals("null")) {
            throw new MissingIdException("Missing " + idName);
        }
    }

    private static void validateObjectNotNull(Object object, String message) {
        if (object == null) {
            throw new BadRequestException(message);
        }
    }

    private static <T, U> void validateNotNull(Map<T, U> map, String message) {
        validateObjectNotNull(map, message);
        if (map.isEmpty()) {
            throw new BadRequestException(message);
        }
    }

    private static void validateEnumValues(NotificationType type) {

        if (type == null) {
            throw new BadRequestException("Notification type can not be null");
        }

        switch(type) {
            case PUSH_NOTIFICATION:
            case SMS:
                return;
        }

        throw new BadRequestException("Invalid notification type");
    }

    public static void validate(CreateNotificationRequest request) {
        validateEnumValues(request.getNotificationType());
        validate(request.getText(), "Notification text");
        validateNotNull(request.getUsersMetadata(), "Users metadata can not be null");
    }
}