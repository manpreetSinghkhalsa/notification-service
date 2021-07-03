package com.example.demo.internal.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class SmsDto {

    private String text;
    private String phoneNumber;

}
