package com.javatpoint.service;

import com.javatpoint.model.Notification;
import com.javatpoint.model.SMS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QueueService {
    @Autowired
    List<ChannelService> channel;

    public String dequeue(String type) {
        String temp = "";
        if (type.equalsIgnoreCase("email")) {
            temp += channel.get(0).dequeue();
        } else if (type.equalsIgnoreCase("sms")) {
            temp += channel.get(1).dequeue();
        }
        return temp;
    }
}
