package com.javatpoint.service;

import com.javatpoint.model.Email;
import com.javatpoint.model.Notification;
import com.javatpoint.repository.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
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
        temp.setId(999999999);
        emailRepository.save(temp);
        idCalibration();
        return "Email Notification Has been added to queue";
    }

    public void remove(int id) {
        emailRepository.deleteById(id);
    }

    public String dequeue() {
        String temp = view();
        if (emailRepository.existsById(1)) {
            emailRepository.deleteById(1);
            idCalibration();
        }
        return temp;
    }

    public String view() {
        if (!emailRepository.existsById(1)) {
            return "empty!";
        } else {
            Email temp = emailRepository.findById(1).get();
            return ("==================================================\n" +
                    "--------------------------------------------------\n" +
                    "Subject: " + temp.getSubject() +
                    "\n--------------------------------------------------\n" +
                    temp.getContent() +
                    "\n==================================================\n");
        }
    }

    public void idCalibration() {
        List<Email> Emails = new ArrayList<>();
        emailRepository.findAll().forEach(temp1 -> Emails.add(temp1));
        emailRepository.deleteAll();
        Email temp;
        int min = 1;
        for (int i = 0; i < Emails.size(); i++) {
            temp = new Email(Emails.get(i), min);
            emailRepository.save(temp);
            min++;
        }
    }
}
