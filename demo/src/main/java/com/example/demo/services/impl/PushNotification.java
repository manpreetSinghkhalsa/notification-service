package com.example.demo.services.impl;

import com.example.demo.internal.dtos.PushNotificationDto;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class PushNotification {

    @Async
    public void send(PushNotificationDto notificationDto) {
        // Send Push notification
    }
}
