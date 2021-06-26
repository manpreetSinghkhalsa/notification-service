package com.example.demo.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserMetadata {
    private String phoneNumber;
    private String id;
    private Object firebaseData;
}
