package com.javatpoint.model;

import javax.persistence.*;

@Entity
@Table
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;
    @Column
    private String Subject;
    @Column
    private String Content;
    @Column
    private String Channel;

    public Notification() {
        this.Subject = null;
        this.Content = null;
    }

    public Notification(Template template) {
        this.Subject = template.getSubject();
        this.Content = template.getContent();
    }


    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setSubject(String subject) {
        this.Subject = subject;
    }

    public void setContent(String content) {
        Content = content;
    }

    public String getContent() {
        return Content;
    }

    public String getSubject() {
        return Subject;
    }

    public String getChannel() {
        return Channel;
    }

    public void setChannel(String channel) {
        Channel = channel;
    }
}
