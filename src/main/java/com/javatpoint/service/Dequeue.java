package com.javatpoint.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class Dequeue {
    @Autowired
    public static NotificationService NotifService;
    public static void main (String args[]){
        NotifService.dequeueAll();
    }


}
