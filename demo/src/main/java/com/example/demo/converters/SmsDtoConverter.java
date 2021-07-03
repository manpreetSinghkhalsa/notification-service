package com.example.demo.converters;

import com.example.demo.bos.NotificationBo;
import com.example.demo.dtos.UserMetadata;
import com.example.demo.internal.dtos.SmsDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class SmsDtoConverter implements Converter<NotificationBo, SmsDto> {


    @Override
    public List<SmsDto> convertToDtoList(NotificationBo notificationBo) {

        List<SmsDto> smsDtoList = new ArrayList<>();

        for (Map.Entry<String, UserMetadata> entry : notificationBo.getUsersMetadata().entrySet()) {
            smsDtoList.add(convertToDto(entry.getValue(), notificationBo.getText()));
        }

        return smsDtoList;
    }

    private SmsDto convertToDto(UserMetadata userMetadata, String text) {
        return new SmsDto(text, userMetadata.getPhoneNumber());
    }

}
