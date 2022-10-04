package com.greenfoxacademy.mentors.Models;

import javax.persistence.*;

@Entity
public class Mentor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "classSubject_id")
    ClassSubject classSubject;

    public Mentor() {
    }

    public Mentor(String name) {
        this.name = name;
    }

    public Mentor(String name, ClassSubject classSubject) {
        this.name = name;
        this.classSubject = classSubject;
    }

    public Mentor(Long id, String name, ClassSubject classSubject) {
        this.id = id;
        this.name = name;
        this.classSubject = classSubject;
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

    public ClassSubject getClassSubject() {
        return classSubject;
    }

    public void setClassSubject(ClassSubject classSubject) {
        this.classSubject = classSubject;
    }
}
