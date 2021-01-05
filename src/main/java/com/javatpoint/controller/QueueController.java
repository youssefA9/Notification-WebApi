package com.javatpoint.controller;

import com.javatpoint.model.Notification;
import com.javatpoint.model.stringWrapper;
import com.javatpoint.service.QueueService;
import com.javatpoint.service.TemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

public class QueueController {

    @Autowired
    QueueService Queue;

    @GetMapping("/dequeue")
    private List<String> dequeueNotification(@RequestBody String choice, String count) {
        List<String> templist = new ArrayList<>();
        if (choice.equalsIgnoreCase("email")) {
            if (count.equalsIgnoreCase("all")) {
                templist.add(dequeueEmail());
            }
        } else if (choice.equalsIgnoreCase("sms")) {
            if (count.equalsIgnoreCase("all")) {
                templist.add(dequeueEmail());
            }
        }
        return templist;
    }

    private String dequeueEmail() {
        return Queue.dequeue("Email");
    }

    private String dequeueSMS() {
        return Queue.dequeue("sms");
    }
}
