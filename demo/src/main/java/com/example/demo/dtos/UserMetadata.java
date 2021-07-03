package com.example.demo.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserMetadata {
    private String phoneNumber;
    // Assumption: we will need this id to send push-notification to the end user
    private String id;
}
