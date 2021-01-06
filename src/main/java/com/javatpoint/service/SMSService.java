package com.javatpoint.service;

import com.javatpoint.model.Email;
import com.javatpoint.model.Notification;
import com.javatpoint.model.SMS;
import com.javatpoint.repository.SMSRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
        temp.setId(999999999);
        smsRepository.save(temp);
        idCalibration();
        return "SMS Notification Has been added to queue";
    }

    public void remove(int id) {
        smsRepository.deleteById(id);
    }

    public String dequeue() {
        String temp = view();
        if (smsRepository.existsById(1)) {
            smsRepository.deleteById(1);
            idCalibration();
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

    public void idCalibration() {
        List<SMS> sms = new ArrayList<>();
        smsRepository.findAll().forEach(temp1 -> sms.add(temp1));
        smsRepository.deleteAll();
        SMS temp;
        int min = 1;
        for (int i = 0; i < sms.size(); i++) {
            temp = new SMS(sms.get(i), min);
            smsRepository.save(temp);
            min++;
        }
    }
}
