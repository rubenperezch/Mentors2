package com.greenfoxacademy.mentors2.Controllers;

import com.greenfoxacademy.mentors2.Services.MentorService;
import com.greenfoxacademy.mentors2.Services.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {

    MentorService mentorService;

    SubjectService subjectService;

    @Autowired
    public MainController(MentorService mentorService, SubjectService subjectService) {
        this.mentorService = mentorService;
        this.subjectService = subjectService;
    }

    @GetMapping("/")
    public String renderHomePage(Model model) {
        model.addAttribute("mentors",mentorService.returnListMentors());
        model.addAttribute("subjects",subjectService.returnListSubjects());
        return "index";
    }

    @PostMapping("/mentor")
    public String addMentor(Model model, @RequestParam String name, @RequestParam String subName) {
        if(mentorService.mentorExists(name) == false && subjectService.subjectExists(subName) == true) {
            mentorService.addMentor(name,subName);
            model.addAttribute("mentors",mentorService.returnListMentors());
            model.addAttribute("subjects",subjectService.returnListSubjects());
            return "redirect:/mentor/"+mentorService.findMentorByName(name).getId();
        } else {
            return "error";
        }
    }

    @GetMapping("/mentor/{id}")
    public String viewMentor(Model model, @PathVariable (required = false) Long id) {
        model.addAttribute("mentors",mentorService.findMentorById(id));
        model.addAttribute("class", mentorService.findMentorById(id).getSubject().getSubName());
        return "mentor";
    }

}
