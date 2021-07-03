package com.example.demo.services.impl;

import com.example.demo.bos.NotificationBo;
import com.example.demo.converters.Converter;
import com.example.demo.converters.SmsDtoConverter;
import com.example.demo.dtos.NotificationRequestDto;
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

    @Autowired
    private Converter<NotificationBo, NotificationRequestDto> notificationRequestConverter;

    @Autowired
    private Converter<NotificationBo, SmsDto> smsDtoConverter;

    @Autowired
    private Converter<NotificationBo, PushNotificationDto> pushNotificationDtoConverter;

    @Override
    public void generateNotification(NotificationRequestDto request) {
        DataValidators.validate(request);
        NotificationBo bo = notificationRequestConverter.convertToBo(request);
        sendNotification(bo);
    }

    private void sendNotification(NotificationBo notificationBo) {

        switch (notificationBo.getNotificationType()) {

            case SMS:
                initiateSmsNotification(notificationBo);
                break;

            case PUSH_NOTIFICATION:
                initiatePushNotification(notificationBo);
                break;
        }
    }

    private void initiateSmsNotification(NotificationBo bo) {
        List<SmsDto> smsDtoList = smsDtoConverter.convertToDtoList(bo);
        smsDtoList.forEach(smsNotification::send);
    }

    private void initiatePushNotification(NotificationBo bo) {
        List<PushNotificationDto> pushNotificationDtoList = pushNotificationDtoConverter.convertToDtoList(bo);
        pushNotificationDtoList.forEach(pushNotification::send);
    }
}
