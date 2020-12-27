package com.javatpoint.model;

import javax.persistence.*;

@Entity
@Table
public class Notification {
    @Id
    @GeneratedValue
    @Column
    private int id;
    @Column
    private String Subject;
    @Column
    private String Content;
    @Column
    private boolean channel; //sms is true;

    public Notification() {
        this.Subject = null;
        this.Content = null;
        this.channel = false;
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

    public void setChannel(boolean Channel) { channel = Channel; }

    public String getContent() {
        return Content;
    }

    public String getSubject() {
        return Subject;
    }

    public boolean getChannel() {
        return channel;
    }

}
