package com.javatpoint.controller;

import com.javatpoint.model.stringWrapper;
import com.javatpoint.service.QueueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class QueueController {

    @Autowired
    QueueService Queue;

    @GetMapping("/dequeue")
    private List<String> dequeueNotification(@RequestBody stringWrapper inputs) {
        List<String> templist = new ArrayList<>();
        String temp = "";
        if (inputs.str.get(0).equalsIgnoreCase("email")) {
            if (inputs.str.get(1).equalsIgnoreCase("all")) {
                while (true) {
                    temp = dequeueEmail();
                    if (temp.equalsIgnoreCase("empty!")) {
                        break;
                    } else {
                        templist.add(temp);
                    }
                }
            } else {
                for (int i = 0; i < Integer.valueOf(inputs.str.get(1)); i++) {
                    temp = dequeueEmail();
                    if (temp.equalsIgnoreCase("empty!")) {
                        break;
                    } else {
                        templist.add(temp);
                    }
                }
            }
        } else if (inputs.str.get(0).equalsIgnoreCase("sms")) {
            if (inputs.str.get(1).equalsIgnoreCase("all")) {
                while (true) {
                    temp = dequeueSMS();
                    if (temp.equalsIgnoreCase("empty!")) {
                        break;
                    } else {
                        templist.add(temp);
                    }
                }
            } else {
                for (int i = 0; i < Integer.valueOf(inputs.str.get(1)); i++) {
                    temp = dequeueSMS();
                    if (temp.equalsIgnoreCase("empty!")) {
                        break;
                    } else {
                        templist.add(temp);
                    }
                }
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
