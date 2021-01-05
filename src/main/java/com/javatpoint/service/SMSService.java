package com.javatpoint.service;

import com.javatpoint.model.Notification;
import com.javatpoint.model.SMS;
import com.javatpoint.repository.SMSRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class SMSService implements ChannelService {

    @Autowired
    SMSRepository smsRepository;

    public SMSService() {
    }

    @Override
    public String add(Notification Notif) {
        SMS temp = new SMS();
        temp.setSubject(Notif.getSubject());
        temp.setContent(Notif.getContent());
        smsRepository.save(temp);
        return "SMS Notification Has been added to queue";

    }
}
