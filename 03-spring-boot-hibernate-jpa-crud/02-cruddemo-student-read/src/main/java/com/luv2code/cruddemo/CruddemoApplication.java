package com.luv2code.cruddemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.luv2code.cruddemo.entities.Student;
import com.luv2code.cruddemo.repositories.StudentDAO;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner -> {
			// createStudent(studentDAO);
			// createMultipleStudents(studentDAO);
			readStudent(studentDAO);
		}; 
	}

	private void readStudent(StudentDAO studentDAO) {
		System.out.println("Creating new student ...");
		Student student = new Student("Daffy", "Duck", "daffy@luv2code.com");

		System.out.println("Saving the student ...");
		studentDAO.save(student);

		int id = student.getId();
		System.out.println("Saved student, Generated id: " + id);
		
		Student myStudent = studentDAO.find(id);
		System.out.println("Found the student: " + myStudent);
	}

	private void createMultipleStudents(StudentDAO studentDAO) {
	// create the multiple student object
		System.out.println("Creating new student ...");
		Student student1 = new Student("Paul", "Doe", "paul@luv2code.com");
		Student student2 = new Student("Mary", "Public", "mary@luv2code.com");
		Student student3 = new Student("Bonita", "Applebum", "bonita@luv2code.com");

		// save the students
		System.out.println("Saving the students ...");
		studentDAO.save(student1);
		studentDAO.save(student2);
		studentDAO.save(student3);


	}
			
	private void createStudent(StudentDAO studentDAO) {
	// create the student object
	System.out.println("Creating new student ...");
	Student student = new Student("Paul", "Doe", "paul@luv2code.com");
 
	// save the student
	System.out.println("Saving student ...");
	studentDAO.save(student);

	// display the id of the saved student
	System.out.println("Saved student, Generated id: " + student.getId());
	}
}
