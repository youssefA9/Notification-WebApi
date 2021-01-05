package com.javatpoint.service;

import com.javatpoint.model.Email;
import com.javatpoint.model.Notification;
import com.javatpoint.model.SMS;
import com.javatpoint.repository.SMSRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("SMSService")
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

    public void remove(int id) {
        smsRepository.deleteById(id);
    }

    public String dequeue() {
        String temp = view();
        if (smsRepository.existsById(1)) {
            smsRepository.deleteById(1);
        }
        return temp;
    }

    public String view() {
        if (!smsRepository.existsById(1)) {
            return "empty!";
        } else {
            SMS temp = smsRepository.findById(1).get();
            return ("==================================================\n" +
                    temp.getContent() +
                    "\n==================================================\n");
        }
    }
}
