package com.example.demo.controllers;

import com.example.demo.bos.NotificationBo;
import com.example.demo.converters.Converter;
import com.example.demo.dtos.NotificationRequestDto;
import com.example.demo.services.Operations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/v1/notification/")
public class NotificationController {

    @Autowired
    private Operations operations;

    /*
     * Single api to support bulk and single notification
     */
    @PostMapping
    public ResponseEntity<?> sendNotification(@RequestBody NotificationRequestDto body) {
        operations.generateNotification(body);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
