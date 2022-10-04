package com.greenfoxacademy.mentors2.Controllers;

import com.greenfoxacademy.mentors2.DOTs.UpdateDTO;
import com.greenfoxacademy.mentors2.Services.MentorService;
import com.greenfoxacademy.mentors2.Services.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ApiController {

    MentorService mentorService;

    SubjectService subjectService;

    @Autowired
    public ApiController(MentorService mentorService, SubjectService subjectService) {
        this.mentorService = mentorService;
        this.subjectService = subjectService;
    }

    @GetMapping("/mentors")
    ResponseEntity returnListMentorsApi(@RequestParam (required = false, defaultValue = "") String className) {

        if(subjectService.subjectExists(className) == false) {
            return ResponseEntity.status(400).build();
        }
        return ResponseEntity.ok(subjectService.findListMentors(className));
    }

    @PutMapping("/mentors/{mentorId}")
    public ResponseEntity updateMentorApi(@PathVariable (required = false) Long mentorId, @RequestBody UpdateDTO updateDTO) {
        if(mentorService.mentorExists(mentorService.findMentorById(mentorId).getName()) == true && subjectService.subjectExists(updateDTO.getClassName()) == true) {
            mentorService.updateMentor(mentorId, updateDTO);
            return ResponseEntity.ok("Mentor Updated");
        } else if (subjectService.subjectExists(updateDTO.getClassName()) == false) {
            return ResponseEntity.status(400).build();
        } else {
            return ResponseEntity.status(404).build();
        }
    }

}
