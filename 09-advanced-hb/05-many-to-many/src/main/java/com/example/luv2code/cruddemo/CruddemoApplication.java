package com.example.luv2code.cruddemo;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.luv2code.cruddemo.dao.IDAO;
import com.example.luv2code.cruddemo.entities.Course;
import com.example.luv2code.cruddemo.entities.Student;

@SpringBootApplication
public class CruddemoApplication {
  
	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	} 

	@Bean
	public CommandLineRunner commmandLineRunner(IDAO appDAO){
		
		return runner -> {
			// createStudent(appDAO);
			// findCourseAndStudents(appDAO);
			findStudentAndCourses(appDAO);
		};

		
	}

	private void findStudentAndCourses(IDAO appDAO) {
		int id = 2;

		Student student = appDAO.findStudentAndCoursesById(id);

		System.out.println(student);
		System.out.println(student.getCourses());
	}

	private void findCourseAndStudents(IDAO appDAO) {
		int id = 10;

		Course course = appDAO.findCourseAndStudentsById(id);
		System.out.println(course);
		System.out.println(course.getStudents());
	}

	private void createStudent(IDAO appDAO) {
		Course course = new Course("Pacman - How to reach 100 million points");

		Student student1 = new Student("Mario", "Biscotti", "mario@luv2code.com");
		Student student2 = new Student("Luigi", "Cheesecake", "luigi@luv2code.com");

		course.addStudent(student1);
		course.addStudent(student2);

		System.out.println("Saving the course: " + course);
		System.out.println("associated students: " + course.getStudents());
		
		appDAO.save(course);

	}
}
