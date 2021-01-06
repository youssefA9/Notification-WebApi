package com.javatpoint.model;

import javax.persistence.*;

@Entity
@Table
public class Email {

    @Id
    @Column
    private int id;
    @Column
    private String Subject;
    @Column
    private String Content;

    public Email() {
    }

    public Email(Email email, int id) {
        this.id = id;
        this.Subject = email.getSubject();
        this.Content = email.getContent();
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
