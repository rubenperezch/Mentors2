package com.greenfoxacademy.mentors.DTOs;

import com.greenfoxacademy.mentors.Models.Mentor;

import java.util.List;

public class ReturnDTO {

    private List<String> listMentors;

    public List<String> getListMentors() {
        return listMentors;
    }

    public void setListMentors(List<String> listMentors) {
        this.listMentors = listMentors;
    }
}
