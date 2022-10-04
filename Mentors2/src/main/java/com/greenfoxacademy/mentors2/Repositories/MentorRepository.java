package com.greenfoxacademy.mentors2.Repositories;

import com.greenfoxacademy.mentors2.Models.Mentor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MentorRepository extends JpaRepository<Mentor, Long> {

    public Mentor findFirstByName(String name);

    public Boolean existsMentorByName(String name);

    public Mentor findFirstById(Long id);

    public List<Mentor> findAllBySubject(String className);
}
