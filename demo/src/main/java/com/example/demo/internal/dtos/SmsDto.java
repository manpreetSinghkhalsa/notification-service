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
public class SmsDto {

    private String text;
    private String phoneNumber;

    public static List<SmsDto> convertToDto(CreateNotificationRequest request) {

        List<SmsDto> smsDtoList = new ArrayList<>();

        for (Map.Entry<String, UserMetadata> entry : request.getUsersMetadata().entrySet()) {
            smsDtoList.add(convertToDto(entry.getValue(), request.getText()));
        }

        return smsDtoList;
    }

    private static SmsDto convertToDto(UserMetadata userMetadata, String text) {
        return new SmsDto(text, userMetadata.getPhoneNumber());
    }

}
