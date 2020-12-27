package com.javatpoint.service;

import com.javatpoint.model.Notification;
import com.javatpoint.repository.EmailRepository;
import com.javatpoint.repository.NotificationsRepository;
import com.javatpoint.repository.SMSRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NotificationService {
    @Autowired
    NotificationsRepository NotifRepository;
    SMSRepository sms;
    EmailRepository email;
    public List<Notification> getAllNotifications() {
        List<Notification> Notifications = new ArrayList<Notification>();
        NotifRepository.findAll().forEach(temp -> Notifications.add(temp));
        return Notifications;
    }

    public void addNotification(Notification Notif) {
        //sms is true
        if(Notif.getChannel()){ sms.save(Notif); }

        else{email.save(Notif);}


        NotifRepository.save(Notif);
    }

}
