package com.example.demo.bos;

import com.example.demo.dtos.UserMetadata;
import com.example.demo.enums.NotificationType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;

@Getter
@Setter
@AllArgsConstructor
public class NotificationBo {

    private NotificationType notificationType;
    private String text;

    /*
     * This will have user-id to meta-data required to send notification, for example for sms: Object will
     */
    private HashMap<String, UserMetadata> usersMetadata;

}
