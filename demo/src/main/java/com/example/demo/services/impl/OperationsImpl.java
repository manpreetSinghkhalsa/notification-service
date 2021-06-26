package com.example.demo.services.impl;

import com.example.demo.dtos.CreateNotificationRequest;
import com.example.demo.internal.dtos.PushNotificationDto;
import com.example.demo.internal.dtos.SmsDto;
import com.example.demo.services.Operations;
import com.example.demo.validators.DataValidators;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OperationsImpl implements Operations {

    @Autowired
    private SmsNotification smsNotification;

    @Autowired
    private PushNotification pushNotification;

    @Override
    public void generateNotification(CreateNotificationRequest request) {
        DataValidators.validate(request);
        sendNotification(request);
    }

    void sendNotification(CreateNotificationRequest request) {

        switch (request.getNotificationType()) {

            case SMS:
                initiateSmsNotification(request);
                break;

            case PUSH_NOTIFICATION:
                initiatePushNotification(request);
                break;
        }
    }

    private void initiateSmsNotification(CreateNotificationRequest request) {
        List<SmsDto> dtos = SmsDto.convertToDto(request);
        for (SmsDto dto : dtos) {
            smsNotification.send(dto);
        }
    }

    private void initiatePushNotification(CreateNotificationRequest request) {
        List<PushNotificationDto> dtos = PushNotificationDto.convertToDto(request);
        for (PushNotificationDto dto : dtos) {
            pushNotification.send(dto);
        }
    }
}
