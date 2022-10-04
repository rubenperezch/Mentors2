package com.greenfoxacademy.mentors;

import com.greenfoxacademy.mentors.Models.ClassSubject;
import com.greenfoxacademy.mentors.Services.ClassSubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MentorsApplication implements CommandLineRunner {

    /*ClassSubjectService classSubjectService;

    @Autowired
    public MentorsApplication(ClassSubjectService classSubjectService) {
        this.classSubjectService = classSubjectService;
    }*/

    public static void main(String[] args) {
        SpringApplication.run(MentorsApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        /*ClassSubject java = new ClassSubject("Java");
        ClassSubject python = new ClassSubject("Python");
        ClassSubject javaScript = new ClassSubject("JavaScript");

        classSubjectService.addClassSubject(java);
        classSubjectService.addClassSubject(python);
        classSubjectService.addClassSubject(javaScript);*/


    }
}
