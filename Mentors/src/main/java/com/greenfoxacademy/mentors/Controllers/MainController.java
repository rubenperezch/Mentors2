package com.greenfoxacademy.mentors.Controllers;

import com.greenfoxacademy.mentors.Services.ClassSubjectService;
import com.greenfoxacademy.mentors.Services.MentorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    MentorService mentorService;

    ClassSubjectService classSubjectService;

    @Autowired
    public MainController(MentorService mentorService, ClassSubjectService classSubjectService) {
        this.mentorService = mentorService;
        this.classSubjectService = classSubjectService;
    }

    @GetMapping("/")
    public String renderHomePage(Model model) {
        model.addAttribute("mentors",mentorService.findAllMentors());
        model.addAttribute("classes",classSubjectService.findAllClassSubjects());
        return "index";
    }

    @PostMapping("/mentor")
    public String returnAddMentor(@RequestParam String mentorName, String className) {

        if (mentorService.mentorExists(mentorName) == true) {
            return "error";
        }

        mentorService.addMentor(mentorName,classSubjectService.findClassSubjectbyClassName(className));

        return "redirect:/";
    }

    @GetMapping("/mentor/{id}")
    public String renderMentorPage(Model model, @PathVariable Long id) {
        model.addAttribute("mentors",mentorService.findFirstById(id));
        model.addAttribute("class",mentorService.findFirstById(id).getClassSubject().getClassName());

        return "mentor";
    }
}
