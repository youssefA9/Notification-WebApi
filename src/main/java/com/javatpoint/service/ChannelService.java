package com.javatpoint.service;

import com.javatpoint.model.Notification;
import org.springframework.stereotype.Service;

@Service
public interface ChannelService {
    public String add(Notification Notif);

    public void remove(int id);

    public String dequeue();

    public String view();

}
