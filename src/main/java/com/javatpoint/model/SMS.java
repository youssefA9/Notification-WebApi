package com.javatpoint.model;

import javax.persistence.*;

@Entity
@Table
public class SMS {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;
    @Column
    private String Subject;
    @Column
    private String Content;

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
