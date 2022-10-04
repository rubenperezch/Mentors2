package com.greenfoxacademy.mentors.Repositories;

import com.greenfoxacademy.mentors.Models.Mentor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MentorRepository extends JpaRepository<Mentor, Long> {

    public Mentor findFirstById(Long id);

    public Boolean existsMentorByName(String name);

    List<Mentor> findMentorsByClassSubjectClassName(String className);

    List<Mentor> findMentorsByClassSubjectId(Long id);

    public Boolean existsMentorById(Long id);
}
