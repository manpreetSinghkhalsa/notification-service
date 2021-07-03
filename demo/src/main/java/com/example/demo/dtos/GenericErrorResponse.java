package com.example.demo.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor(staticName = "from")
public class GenericErrorResponse {

    public static final int ERROR_GENERIC = -1;

    private int errorCode;
    private String message;
}