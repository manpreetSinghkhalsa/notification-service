package com.example.demo.validators;

import com.example.demo.dtos.NotificationRequestDto;
import com.example.demo.dtos.UserMetadata;
import com.example.demo.enums.NotificationType;
import com.example.demo.exceptions.BadRequestException;
import com.example.demo.exceptions.MissingIdException;
import org.apache.commons.lang.StringUtils;

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

    public static <T extends Enum<T>> T enumValue(String string, Class<T> enumClass, String fieldName) {

        if (StringUtils.isBlank(string)) {
            throw new BadRequestException("Invalid value for " + fieldName);
        }

        try {
            return Enum.valueOf(enumClass, string.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new BadRequestException("Invalid value for " + fieldName);
        }
    }

    private static void validateUsersMetadata(Map<String, UserMetadata> metadata, NotificationType type) {

        for (UserMetadata userMetadata : metadata.values()) {

            switch (type) {

                case SMS:
                    if (userMetadata.getPhoneNumber() == null || userMetadata.getPhoneNumber().trim().isEmpty()) {
                        throw new BadRequestException("Phone number and Firebase id, both can not empty");
                    }
                    break;

                case PUSH_NOTIFICATION:
                    if (userMetadata.getId() == null || userMetadata.getId().trim().isEmpty()) {
                        throw new BadRequestException("Firebase id can not empty");
                    }
                    break;
            }
        }
    }

    public static void validate(NotificationRequestDto request) {
        NotificationType type = enumValue(request.getNotificationType(), NotificationType.class, "Notification type");
        validate(request.getText(), "Notification text");
        validateNotNull(request.getUsersMetadata(), "Users metadata can not be null");
        validateUsersMetadata(request.getUsersMetadata(), type);
    }
}