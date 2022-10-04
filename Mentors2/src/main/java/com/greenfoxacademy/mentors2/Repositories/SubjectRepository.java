package com.greenfoxacademy.mentors2.Repositories;

import com.greenfoxacademy.mentors2.Models.Mentor;
import com.greenfoxacademy.mentors2.Models.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long> {

    public Subject findFirstBySubName(String subName);

    public Boolean existsSubjectBySubName(String subName);

}
