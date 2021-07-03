package com.example.demo.services.impl;

import com.example.demo.exceptions.SendNotificationFailedException;
import com.example.demo.internal.dtos.SmsDto;
import com.example.demo.services.NotificationService;
import org.springframework.stereotype.Service;


@Service
public class SmsNotification implements NotificationService<SmsDto> {

    public void send(SmsDto notificationDto) {
        try {
            sendSms(notificationDto);
        } catch (Exception exception) {
            throw new SendNotificationFailedException("Sms Notification failed!");
        }
    }

    private void sendSms(SmsDto dto) {
        // Send Sms
    }
}
