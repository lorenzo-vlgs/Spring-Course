package com.example.luv2code.cruddemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.luv2code.cruddemo.dao.IDAO;
import com.example.luv2code.cruddemo.entities.Instructor;
import com.example.luv2code.cruddemo.entities.InstructorDetail;

@SpringBootApplication
public class CruddemoApplication {
 
	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commmandLineRunner(IDAO appDAO){
		
		return runner -> {
			// createIntrusctor(appDAO);
			// findInstructorById(appDAO);
			findInstructorDetailById(appDAO);
		};
	}

	private void findInstructorDetailById(IDAO appDAO) {
		int id = 1;

		InstructorDetail result = appDAO.findInstructorDetailById(id);

		System.out.println("Detail: " + result);
		System.out.println("Instructor: " + result.getInstructor());
	}

	private void findInstructorById(IDAO appDAO) {
		int id = 1;

		Instructor result = appDAO.findInstructorById(id);

		System.out.println(result);
	}

	private void createIntrusctor(IDAO appDAO) {
		
		// // create instructor
		// Instructor temp = new Instructor("Mario","Biscotti","mario@luv2code.com");
		// InstructorDetail details = new InstructorDetail("youtube", "luv 2 code!");

		// // associate the objects
		// temp.setInstructorDetail(details);



		Instructor temp = new Instructor("Madhu","Patel","madhu@luv2code.com");
		InstructorDetail details = new InstructorDetail("youtube", "luv 2 code!");

		// associate the objects
		temp.setInstructorDetail(details);
		// save the instructor
		appDAO.save(temp);
		System.out.println("===>> Create instructor: DONE");
	}
}
