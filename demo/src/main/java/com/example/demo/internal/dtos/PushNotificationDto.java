package com.example.demo.internal.dtos;

import com.example.demo.dtos.CreateNotificationRequest;
import com.example.demo.dtos.UserMetadata;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class PushNotificationDto {

    private String text;
    private String id;

    public static List<PushNotificationDto> convertToDto(CreateNotificationRequest request) {

        List<PushNotificationDto> list = new ArrayList<>();

        for (Map.Entry<String, UserMetadata> entry : request.getUsersMetadata().entrySet()) {
            list.add(convertToDto(entry.getValue(), request.getText()));
        }

        return list;
    }

    private static PushNotificationDto convertToDto(UserMetadata userMetadata, String text) {
        return new PushNotificationDto(text, userMetadata.getId());
    }

}
