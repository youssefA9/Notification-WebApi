package com.javatpoint.service;

import com.javatpoint.model.Notification;
import com.javatpoint.model.Template;
import com.javatpoint.repository.NotificationsRepository;
import org.aspectj.weaver.ast.Not;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NotificationService {
    @Autowired
    NotificationsRepository NotifRepository;

    public List<Notification> getAll(){
        List<Notification> Notifications = new ArrayList<Notification>();
        NotifRepository.findAll().forEach(temp -> Notifications.add(temp));
        return Notifications;
    }

    public void addNotification(Notification Notif) {
        NotifRepository.save(Notif);
    }

}
