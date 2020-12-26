package com.javatpoint.controller;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.javatpoint.model.Notification;
import com.javatpoint.model.Template;
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

    @PostMapping("/notification/constr/{id}")
    private String constructNotification(@PathVariable("id") int id, @RequestBody stringWrapper placeHolders) {

        Notification constructedNotif = new Notification(TemplateServ.readTemplate(id));

        int z = 0;
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


        NotifService.addNotification(constructedNotif);
        return "Notification Has been Constructed";
    }

}
