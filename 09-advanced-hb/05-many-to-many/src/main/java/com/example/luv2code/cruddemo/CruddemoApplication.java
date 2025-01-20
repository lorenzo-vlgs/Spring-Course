package com.example.luv2code.cruddemo;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.luv2code.cruddemo.dao.IDAO;
import com.example.luv2code.cruddemo.entities.Course;
import com.example.luv2code.cruddemo.entities.Review;

@SpringBootApplication
public class CruddemoApplication {
  
	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	} 

	@Bean
	public CommandLineRunner commmandLineRunner(IDAO appDAO){
		
		return runner -> {
			// createCourseAndReviews(appDAO);
			// findCourseAndReviews(appDAO);
			// deleteCourseAndReviews(appDAO);
			
		};

		
	}

	private void deleteCourseAndReviews(IDAO appDAO) {
		int id = 10;

		System.out.println("Deleting course id: " + id);
		appDAO.deleteCourseById(id);
		System.out.println("Done");
	}

	private void findCourseAndReviews(IDAO appDAO) {
		int id = 10;
		Course temp	= appDAO.findCourseAndReviewsById(id);

		System.out.println(temp);
		System.out.println(temp.getReviews());
		System.out.println("Done");
	}

	private void createCourseAndReviews(IDAO appDAO) {
		Course temp = new Course("Pacman - How to score one million points");

		temp.add(new Review("Great course ... loved it!"));
		temp.add(new Review("Great course, job well done."));
		temp.add(new Review("What a dumb course, you are an idiot!"));

		appDAO.save(temp);
		System.out.println("Saving the course");
		 

	}
}
