package com.example.demo.services.impl;

import com.example.demo.exceptions.SendNotificationFailedException;
import com.example.demo.internal.dtos.PushNotificationDto;
import com.example.demo.services.NotificationService;
import org.springframework.stereotype.Service;


@Service
public class PushNotification implements NotificationService<PushNotificationDto> {

    public void send(PushNotificationDto notificationDto) {
        try {
            sendPushNotification(notificationDto);
        } catch (Exception exception) {
            throw new SendNotificationFailedException("Sms Notification failed!");
        }
    }

    private void sendPushNotification(PushNotificationDto dto) {
        // Send push notification
    }

}
