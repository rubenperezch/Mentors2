package com.greenfoxacademy.mentors2.Models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String subName;

    @OneToMany(mappedBy = "subject")
    private List<Mentor> mentorList;

    public Subject() {
    }

    public Subject(String subName) {
        this.subName = subName;
        this.mentorList = new ArrayList<>();
    }

    public Subject(Long id, String subName) {
        this.id = id;
        this.subName = subName;
        this.mentorList = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSubName() {
        return subName;
    }

    public void setSubName(String subName) {
        this.subName = subName;
    }

    public List<Mentor> getMentorList() {
        return mentorList;
    }

    public void setMentorList(List<Mentor> mentorList) {
        this.mentorList = mentorList;
    }
}
