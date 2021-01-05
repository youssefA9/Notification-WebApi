package com.javatpoint.service;

import com.javatpoint.model.Email;
import com.javatpoint.model.Notification;
import com.javatpoint.model.SMS;
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
    ChannelService channel;

    public List<Notification> getAllNotifications() {
        List<Notification> Notifications = new ArrayList<Notification>();
        NotifRepository.findAll().forEach(temp -> Notifications.add(temp));
        return Notifications;
    }

    public String addNotification(Notification Notif) {
        NotifRepository.save(Notif);
        if (Notif.getChannel().equalsIgnoreCase("sms")) {
            channel = new SMSService();
            return "Notification Has Been Constructed" + "\n" + channel.add(Notif);
        } else if (Notif.getChannel().equalsIgnoreCase("email")) {
            channel = new EmailService();
            return "Notification Has Been Constructed" + "\n" + channel.add(Notif);
        } else {
            return "Notification Has been Constructed But hadn't been add to any queue";
        }
    }

    public void dequeue(Notification Notif) {
        NotifRepository.delete(Notif);
    }
}
