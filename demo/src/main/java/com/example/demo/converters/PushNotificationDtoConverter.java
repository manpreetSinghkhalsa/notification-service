package com.example.demo.converters;

import com.example.demo.bos.NotificationBo;
import com.example.demo.dtos.UserMetadata;
import com.example.demo.internal.dtos.PushNotificationDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class PushNotificationDtoConverter implements Converter<NotificationBo, PushNotificationDto> {

    @Override
    public List<PushNotificationDto> convertToDtoList(NotificationBo bo) {

        List<PushNotificationDto> list = new ArrayList<>();

        for (Map.Entry<String, UserMetadata> entry : bo.getUsersMetadata().entrySet()) {
            list.add(convertToDto(entry.getValue(), bo.getText()));
        }

        return list;
    }

    private static PushNotificationDto convertToDto(UserMetadata userMetadata, String text) {
        return new PushNotificationDto(text, userMetadata.getId());
    }
}
