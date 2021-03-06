package com.javatpoint.model;

import javax.persistence.*;

@Entity
@Table
public class Template {
    @Id
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

    public Template() {
    }

    public Template(Template template, int id) {
        this.id = id;
        this.Subject = template.getSubject();
        this.Content = template.getContent();
        this.NumOfPlaceholder = template.getNumOfPlaceholder();
        this.Language = template.getLanguage();
    }

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