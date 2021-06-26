package com.example.demo;

import com.example.demo.dtos.CreateNotificationRequest;
import com.example.demo.dtos.UserMetadata;
import com.example.demo.enums.NotificationType;
import com.example.demo.exceptions.BadRequestException;
import com.example.demo.exceptions.MissingIdException;
import com.example.demo.validators.DataValidators;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

public class DataValidatorsTest {

    @Test
    void testValidateCreateNotificationRequest() {

        CreateNotificationRequest request = new CreateNotificationRequest();

        Assertions.assertThrows(BadRequestException.class, () -> {
            DataValidators.validate(request);
        });

        request.setNotificationType(NotificationType.SMS);
        Assertions.assertThrows(MissingIdException.class, () -> {
            DataValidators.validate(request);
        });

        request.setText("Notification text");
        request.setUsersMetadata(null);
        Assertions.assertThrows(BadRequestException.class, () -> {
            DataValidators.validate(request);
        });

        request.setUsersMetadata(new HashMap<>());
        Assertions.assertThrows(BadRequestException.class, () -> {
            DataValidators.validate(request);
        });

        HashMap<String, UserMetadata> data = new HashMap<>();
        data.put("user-id", new UserMetadata());

        request.setUsersMetadata(data);

        Assertions.assertDoesNotThrow(() -> {
            DataValidators.validate(request);
        });
    }
}
