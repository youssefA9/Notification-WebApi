package com.javatpoint.service;

import com.javatpoint.model.Notification;
import com.javatpoint.repository.NotificationsRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class Dequeue {
    @Autowired
    NotificationService NotifService;
    List<Notification> AllNotifications = NotifService.getAllNotifications();

    public void dequeueAll() {
        for (int i = 0; i < AllNotifications.size(); i++) {
            System.out.println(AllNotifications.get(i).getSubject() + " Notification has been sent by " + AllNotifications.get(i).getChannel() + " Method.");
            NotifService.dequeue(AllNotifications.get(i));
        }
    }

}
