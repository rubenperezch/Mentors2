package com.greenfoxacademy.mentors.Services;

import com.greenfoxacademy.mentors.Models.ClassSubject;
import com.greenfoxacademy.mentors.Repositories.ClassSubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassSubjectService {

    ClassSubjectRepository classSubjectRepository;

    @Autowired
    public ClassSubjectService(ClassSubjectRepository classSubjectRepository) {
        this.classSubjectRepository = classSubjectRepository;
    }

    public void addClassSubject(ClassSubject classSubject) {
        classSubjectRepository.save(classSubject);
    }

    public List<ClassSubject> findAllClassSubjects() {
        return classSubjectRepository.findAll();
    }

    public ClassSubject findClassSubjectbyClassName(String nameClass) {
        return classSubjectRepository.findClassSubjectByClassName(nameClass);
    }

    public Boolean existsClassSubjectByClassName(String nameClass) {
        return classSubjectRepository.existsClassSubjectByClassName(nameClass);
    }
}
