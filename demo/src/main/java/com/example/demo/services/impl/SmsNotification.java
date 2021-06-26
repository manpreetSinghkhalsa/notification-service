package com.example.demo.services.impl;

import com.example.demo.internal.dtos.SmsDto;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class SmsNotification {

    @Async
    public void send(SmsDto notificationDto) {
        // Send Sms
    }
}
