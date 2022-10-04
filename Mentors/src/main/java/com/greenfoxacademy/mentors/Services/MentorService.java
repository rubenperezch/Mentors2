package com.greenfoxacademy.mentors.Services;

import com.greenfoxacademy.mentors.DTOs.ReceivedDTO;
import com.greenfoxacademy.mentors.DTOs.ReturnDTO;
import com.greenfoxacademy.mentors.DTOs.Success;
import com.greenfoxacademy.mentors.DTOs.UpdateDTO;
import com.greenfoxacademy.mentors.Models.ClassSubject;
import com.greenfoxacademy.mentors.Models.Mentor;
import com.greenfoxacademy.mentors.Repositories.ClassSubjectRepository;
import com.greenfoxacademy.mentors.Repositories.MentorRepository;
import org.hibernate.loader.custom.Return;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MentorService {

    MentorRepository mentorRepository;

    ClassSubjectRepository classSubjectRepository;

    @Autowired
    public MentorService(MentorRepository mentorRepository, ClassSubjectRepository classSubjectRepository) {
        this.mentorRepository = mentorRepository;
        this.classSubjectRepository = classSubjectRepository;
    }

    public List<Mentor> findAllMentors() {
        return mentorRepository.findAll();
    }

    public void addMentor(String nameMentor, ClassSubject nameClass) {

        Mentor mentor = new Mentor(nameMentor, nameClass);

        if (mentorRepository.existsMentorByName(nameMentor) == true) {

        } else {
            mentorRepository.save(mentor);
        }


    }

    public Mentor findFirstById(Long id) {
        return mentorRepository.findFirstById(id);
    }

    public Boolean mentorExists(String nameMentor) {
        return mentorRepository.existsMentorByName(nameMentor);
    }

    public Object returnMentorsByClassName(ReceivedDTO className) {

        Long classId = classSubjectRepository.findFirstByClassName(className.getClassName()).getId();

        List<Mentor> listOfMentors = mentorRepository.findMentorsByClassSubjectId(classId);

        List<String> mentorList = listOfMentors.stream().map(m ->m.getName()).collect(Collectors.toList());

        ReturnDTO returnDTO = new ReturnDTO();

        returnDTO.setListMentors(mentorList);

        return returnDTO;

    }

    public Object updateMentorByApi(UpdateDTO updateDTO, Long id) {

        Mentor mentor = new Mentor(id, updateDTO.getName(), classSubjectRepository.findClassSubjectByClassName(updateDTO.getClassName()));

        mentorRepository.save(mentor);

        Success success = new Success();
        success.setMessage("All good, mentor updated");

        return success;
    }

    public Boolean existsMentorById(Long id) {


        return mentorRepository.existsMentorById(id);
    }
}
