package com.example.demo.internal.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
public class PushNotificationDto {

    private String text;
    private String id;

}
