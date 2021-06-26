package com.example.demo.dtos;

import com.example.demo.enums.NotificationType;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;

@Getter
@Setter
public class CreateNotificationRequest {

    private NotificationType notificationType;
    private String text;

    /*
     * This will have user-id to meta-data required to send notification, for example for sms: Object will
     */
    private HashMap<String, UserMetadata> usersMetadata;
}
