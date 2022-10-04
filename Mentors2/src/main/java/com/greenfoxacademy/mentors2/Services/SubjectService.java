package com.greenfoxacademy.mentors2.Services;

import com.greenfoxacademy.mentors2.DOTs.MentorDTO;
import com.greenfoxacademy.mentors2.Models.Mentor;
import com.greenfoxacademy.mentors2.Models.Subject;
import com.greenfoxacademy.mentors2.Repositories.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SubjectService {

    SubjectRepository subjectRepository;

    @Autowired
    public SubjectService(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    public List<Subject> returnListSubjects() {
        return subjectRepository.findAll();
    }

    public Boolean subjectExists(String subName) {
        return subjectRepository.existsSubjectBySubName(subName);
    }


    public List<MentorDTO> findListMentors(String className) {

        List<Mentor> mentors = subjectRepository.findFirstBySubName(className).getMentorList();

        List<MentorDTO> mentorDTOS = new ArrayList<>();

        for (Mentor mentor: mentors) {
            MentorDTO mentorDTO = new MentorDTO(mentor.getName());
            mentorDTOS.add(mentorDTO);
        }

        return mentorDTOS;
    }
}
