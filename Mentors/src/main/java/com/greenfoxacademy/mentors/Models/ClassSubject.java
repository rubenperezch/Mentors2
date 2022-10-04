package com.greenfoxacademy.mentors.Models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class ClassSubject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String className;

    @OneToMany(mappedBy = "classSubject")
    private List<Mentor> mentorList;

    public ClassSubject() {
    }

    public ClassSubject(String className) {
        this.className = className;
        this.mentorList = new ArrayList<>();
    }

    public ClassSubject(Long id, String className) {
        this.id = id;
        this.className = className;
        this.mentorList = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public List<Mentor> getMentorList() {
        return mentorList;
    }

    public void setMentorList(List<Mentor> mentorList) {
        this.mentorList = mentorList;
    }
}
