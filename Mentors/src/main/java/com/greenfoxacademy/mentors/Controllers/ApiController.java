package com.greenfoxacademy.mentors.Controllers;

import com.greenfoxacademy.mentors.DTOs.ReceivedDTO;
import com.greenfoxacademy.mentors.DTOs.UpdateDTO;
import com.greenfoxacademy.mentors.Services.ClassSubjectService;
import com.greenfoxacademy.mentors.Services.MentorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Primary
public class ApiController {

    MentorService mentorService;

    ClassSubjectService classSubjectService;

    @Autowired
    public ApiController(MentorService mentorService, ClassSubjectService classSubjectService) {
        this.mentorService = mentorService;
        this.classSubjectService = classSubjectService;
    }

    @GetMapping("/api/mentors")
    public ResponseEntity<Object> renderClassMentors(@RequestBody(required = false) ReceivedDTO className) {

        if (classSubjectService.existsClassSubjectByClassName(className.getClassName()) == true) {

            return ResponseEntity.ok(mentorService.returnMentorsByClassName(className));
        } else{
            return ResponseEntity.status(400).build();
        }

    }

    @PostMapping("/api/mentors/{id}")
    public ResponseEntity<Object> returnUpdateMentor(@PathVariable Long id, @RequestBody UpdateDTO updateDTO) {
        if (classSubjectService.existsClassSubjectByClassName(updateDTO.getClassName()) == true && mentorService.existsMentorById(id) == true) {


            return ResponseEntity.ok(mentorService.updateMentorByApi(updateDTO,id));
        } else if (classSubjectService.existsClassSubjectByClassName(updateDTO.getClassName()) == false){

            return ResponseEntity.status(400).build();
        } else
            return ResponseEntity.status(404).build();

        }

}
