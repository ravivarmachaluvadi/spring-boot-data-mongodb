package com.bezkoder.spring.data.mongodb;

import com.bezkoder.spring.data.mongodb.model.Tutorial;
import com.bezkoder.spring.data.mongodb.repository.TutorialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class SpringBootDataMongodbApplication implements CommandLineRunner {

	@Autowired
	TutorialRepository tutorialRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDataMongodbApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Tutorial tutorial=new Tutorial();
		tutorial.setTitle("Java Spring");
		tutorial.setDescription("Ravi Publications");
		tutorial.setPublished(true);
		tutorial.setAuthors(List.of("Ravi","Varma"));

		long count = tutorialRepository.count();

		System.out.println(count);
		tutorialRepository.save(tutorial);

		List<Tutorial> all = tutorialRepository.findAll();
		all.stream().forEach(tutorial1 -> {
			System.out.println(tutorial1);
		});


	}
}
