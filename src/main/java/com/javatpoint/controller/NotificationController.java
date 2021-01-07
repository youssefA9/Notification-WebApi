package com.javatpoint.controller;

import com.javatpoint.model.Notification;
import com.javatpoint.model.stringWrapper;
import com.javatpoint.service.NotificationService;
import com.javatpoint.service.TemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class NotificationController {
    @Autowired
    NotificationService NotifService;
    @Autowired
    TemplateService TemplateServ;

    @GetMapping("/notification")
    private List<Notification> getAllNotifications() {
        return NotifService.getAllNotifications();
    }

    @PostMapping("/notification/{channel}")
    private String constructNotification(@PathVariable("channel") String channel, @RequestBody stringWrapper placeHolders) {

        String subject = placeHolders.str.get(0);
        Notification constructedNotif = new Notification(TemplateServ.readTemplate(subject, placeHolders.str.size() - 1));
        if (constructedNotif.getSubject() != null) {
            constructedNotif.setChannel(channel);
            int z = 1;
            String c = constructedNotif.getContent();
            for (int i = 0; i < c.length(); i++) {
                if (c.charAt(i) == '#') {
                    String s = c.substring(0, i);
                    c = c.substring(i + 1, c.length());
                    c = s + placeHolders.str.get(z) + c;
                    z++;
                }
            }

            constructedNotif.setContent(c);

            return NotifService.addNotification(constructedNotif);
        } else {
            return "Template with such subject and number of place holders don't exists";
        }
    }

}
