package com.greenfoxacademy.mentors2.Services;

import com.greenfoxacademy.mentors2.DOTs.MentorDTO;
import com.greenfoxacademy.mentors2.DOTs.UpdateDTO;
import com.greenfoxacademy.mentors2.Models.Mentor;
import com.greenfoxacademy.mentors2.Models.Subject;
import com.greenfoxacademy.mentors2.Repositories.MentorRepository;
import com.greenfoxacademy.mentors2.Repositories.SubjectRepository;
import org.hibernate.sql.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MentorService {

    MentorRepository mentorRepository;

    SubjectRepository subjectRepository;

    @Autowired
    public MentorService(MentorRepository mentorRepository, SubjectRepository subjectRepository) {
        this.mentorRepository = mentorRepository;
        this.subjectRepository = subjectRepository;
    }

    public List<Mentor> returnListMentors() {
        return mentorRepository.findAll();
    }

    public void addMentor(String name, String subName) {
        if(mentorRepository.existsMentorByName(name) == false) {

            Mentor mentor = new Mentor(name, subjectRepository.findFirstBySubName(subName));
            mentorRepository.save(mentor);

        } else {

        }
    }

    public Boolean mentorExists(String name) {
        return mentorRepository.existsMentorByName(name);
    }

    public Mentor findMentorById(Long id) {
        return mentorRepository.findFirstById(id);
    }

    public Mentor findMentorByName(String name) {
        return mentorRepository.findFirstByName(name);
    }

    public void updateMentor(Long mentorId, UpdateDTO updateDTO) {

        if(mentorExists(findMentorById(mentorId).getName()) == true) {
            Mentor mentor = new Mentor(mentorId, updateDTO.getName(), subjectRepository.findFirstBySubName(updateDTO.getClassName()));

            mentorRepository.save(mentor);
        }

    }
}
