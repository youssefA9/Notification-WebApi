package com.javatpoint.model;

import javax.persistence.*;

@Entity
@Table
public class Template {
    @Id
    @GeneratedValue
    @Column
    private int id;
    @Column
    private String Subject;
    @Column
    private String Content;
    @Column
    private String Language;
    @Column
    private int NumOfPlaceholder;

    public void setNumOfPlaceholder(int n) {
        this.NumOfPlaceholder = n;
    }

    public int getNumOfPlaceholder() {
        return NumOfPlaceholder;
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

    public void setLanguage(String language) {
        Language = language;
    }

    public String getContent() {
        return Content;
    }

    public String getLanguage() {
        return Language;
    }

    public String getSubject() {
        return Subject;
    }

}