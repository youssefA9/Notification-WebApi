package com.javatpoint.service;

import com.javatpoint.model.Notification;
import com.javatpoint.model.Template;
import com.javatpoint.repository.EmailRepository;
import com.javatpoint.repository.NotificationsRepository;
import com.javatpoint.repository.SMSRepository;
import org.aspectj.weaver.ast.Instanceof;
import org.aspectj.weaver.ast.Not;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NotificationService {
    @Autowired
    NotificationsRepository NotifRepository;
    @Autowired
    SMSRepository smsRepository;
    @Autowired
    EmailRepository emailRepository;

    public List<Notification> getAllNotifications() {
        List<Notification> Notifications = new ArrayList<Notification>();
        NotifRepository.findAll().forEach(temp -> Notifications.add(temp));
        return Notifications;
    }

    public void addSMS(Notification x) {
        smsRepository.save(x);
    }

    public void addEmail(Notification y) {
        emailRepository.save(y);
    }

    public void addNotification(Notification Notif) {
        if (Notif.getChannel().equalsIgnoreCase("sms")) {
            addSMS(Notif);
        } else if (Notif.getChannel().equalsIgnoreCase("email")) {
            addEmail(Notif);
        }
        NotifRepository.save(Notif);

    }

}
