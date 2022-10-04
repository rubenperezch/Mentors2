package com.greenfoxacademy.mentors.Repositories;

import com.greenfoxacademy.mentors.Models.ClassSubject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassSubjectRepository extends JpaRepository<ClassSubject, Long> {

    public ClassSubject findClassSubjectByClassName(String name);

    //@Query(value="SELECT * FROM class_subject WHERE class_name = ?1",nativeQuery = true)
    //ClassSubject findClassSubjectByClassName(String name);

    ClassSubject findFirstByClassName(String name);

    Boolean existsClassSubjectByClassName(String name);
}

