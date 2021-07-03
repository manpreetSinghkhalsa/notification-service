package com.example.demo.converters;

import com.example.demo.bos.NotificationBo;
import com.example.demo.dtos.NotificationRequestDto;
import com.example.demo.enums.NotificationType;
import com.example.demo.validators.DataValidators;
import org.springframework.stereotype.Service;

@Service
public class NotificationRequestConverter implements Converter<NotificationBo, NotificationRequestDto> {

    @Override
    public NotificationBo convertToBo(NotificationRequestDto dto) {
        NotificationType type = DataValidators.enumValue(dto.getNotificationType(), NotificationType.class, "Notification type");
        return new NotificationBo(type, dto.getText(), dto.getUsersMetadata());
    }

}
