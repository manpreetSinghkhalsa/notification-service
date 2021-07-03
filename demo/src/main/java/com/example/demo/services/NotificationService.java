package com.example.demo.services;

public interface NotificationService<T> {

    void send(T dto);

}
