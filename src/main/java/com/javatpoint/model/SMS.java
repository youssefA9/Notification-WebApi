package com.javatpoint.model;

import javax.persistence.*;

@Entity
@Table
public class SMS {

    @Id
    @Column
    private int id;
    @Column
    private String Subject;
    @Column
    private String Content;

    public SMS() {
    }

    public SMS(SMS sms, int id) {
        this.id = id;
        this.Subject = sms.getSubject();
        this.Content = sms.getContent();
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setContent(String content) {
        Content = content;
    }

    public void setSubject(String subject) {
        Subject = subject;
    }

    public int getId() {
        return id;
    }

    public String getContent() {
        return Content;
    }

    public String getSubject() {
        return Subject;
    }
}
