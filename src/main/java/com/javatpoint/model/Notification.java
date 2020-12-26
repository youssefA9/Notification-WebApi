package com.javatpoint.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Notification {
    @Id
    @Column
    private int id;
    @Column
    private String Subject;
    @Column
    private String Content;


    public Notification(Template template){
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

}
