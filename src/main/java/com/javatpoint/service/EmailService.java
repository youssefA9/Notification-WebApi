package com.javatpoint.service;

import com.javatpoint.model.Email;
import com.javatpoint.model.Notification;
import com.javatpoint.repository.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class EmailService implements ChannelService {
    @Autowired
    EmailRepository emailRepository;

    public EmailService() {
    }

    @Override
    public String add(Notification Notif) {
        Email temp = new Email();
        temp.setSubject(Notif.getSubject());
        temp.setContent(Notif.getContent());
        emailRepository.save(temp);
        return "Email Notification Has been added to queue";
    }
}
