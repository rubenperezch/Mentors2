package com.greenfoxacademy.mentors2;

import com.greenfoxacademy.mentors2.Models.Subject;
import com.greenfoxacademy.mentors2.Repositories.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Mentors2Application implements CommandLineRunner {

	/*SubjectRepository subjectRepository;

	@Autowired
	public Mentors2Application(SubjectRepository subjectRepository) {
		this.subjectRepository = subjectRepository;
	}*/

	public static void main(String[] args) {
		SpringApplication.run(Mentors2Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		/*Subject really = new Subject("really");
		Subject robotics = new Subject("robotics");
		Subject maths = new Subject("maths");

		subjectRepository.save(really);
		subjectRepository.save(robotics);
		subjectRepository.save(maths);*/


	}
}
