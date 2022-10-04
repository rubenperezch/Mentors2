package com.greenfoxacademy.mentors2.Models;

import javax.persistence.*;

@Entity
public class Mentor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "subject_id")
    Subject subject;

    public Mentor() {
    }

    public Mentor(String name, Subject subject) {
        this.name = name;
        this.subject = subject;
    }

    public Mentor(Long id, String name, Subject subject) {
        this.id = id;
        this.name = name;
        this.subject = subject;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }
}
