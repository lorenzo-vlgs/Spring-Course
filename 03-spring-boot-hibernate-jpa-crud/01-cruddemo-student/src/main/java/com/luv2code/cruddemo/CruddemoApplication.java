package com.luv2code.cruddemo;

import java.util.List;

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
			createMultipleStudents(studentDAO);
			// readStudent(studentDAO);
			// queryForStudent(studentDAO);
			// queryForStudentById(studentDAO);
			// updateStudent(studentDAO);
			// deleteStudent(studentDAO);
			// deleteAllStudents(studentDAO);
		}; 
	}

	private void deleteAllStudents(StudentDAO studentDAO){
		System.out.println("Deleting all students ...");
		int numRows = studentDAO.deleteAll();
		System.out.println("Sono stati eliminati " + numRows + " elementi ...");
	}
	private void deleteStudent(StudentDAO studentDAO){
		int id = 6;
		System.out.println("Fase di eliminazione dell'utente di id: " + 6 + " ...");
		studentDAO.delete(id);
		System.out.println("Eliminazione eseguita ...");

	}
	private void updateStudent(StudentDAO studentDAO){

		int id = 1;
		Student student = studentDAO.find(id);
		System.out.println("Sto eseguendo l'update ...");
		student.setFirstname("Scooby");
		student.setLastname("Doo");
		student.setEmail("scooby@luv2code.com");

		studentDAO.update(student);
		System.out.println("Updated student: " + student);
	}
	private void queryForStudentById(StudentDAO studentDAO) {
		List<Student> result = studentDAO.findByLastname("Duck");

		System.out.println("All students with lastname: Duck ...");
		for (Student student : result) {
			System.out.println(student);
		}
	}
		
	private void queryForStudent(StudentDAO studentDAO) {
		List<Student> result = studentDAO.findAll();

		System.out.println("All students from a-z ...");
		for( Student s : result){
			System.out.println(s);
		}
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
