package com.example.luv2code.cruddemo;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.luv2code.cruddemo.dao.IDAO;
import com.example.luv2code.cruddemo.entities.Course;
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
			// findInstructorDetailById(appDAO);
			// deleteInstructorDetail(appDAO); 
			// createIntrusctorWithCourses(appDAO);
			// findInstructorWithCourses(appDAO);
			// findCoursesForInstructor(appDAO);
			// findInstructorWithJoinFetch(appDAO);
			updateInstructor(appDAO);
		};
	}

	private void updateInstructor(IDAO appDAO) {
		int id = 1;

		System.out.println("Findinng instructor id: " + id);
		Instructor instructor = appDAO.findInstructorById(id);

		System.out.println("Updating instructor id: " + id);
		instructor.setFirstName("TESTER");
		instructor.setLastName("TESTING");

		appDAO.updateInstructor(instructor);
		System.out.println("==>> DONE");
	}

	private void findInstructorWithJoinFetch(IDAO appDAO) {
		int id = 1;

		System.out.println("Findnig instructor id: " + id);
		Instructor instructor = appDAO.findInstructorWithCourses(id);

		System.out.println("Instructor: " + instructor);
		System.out.println("Courses: " + instructor.getCourses());
		System.out.println("==>> Done");
	}

	private void findCoursesForInstructor(IDAO appDAO) {
		int id = 1;
		System.out.println("Finding instructor id: " + id);

		Instructor temp = appDAO.findInstructorById(id);
		System.out.println("Instructor: " + temp);

		List<Course> courses = appDAO.findCoursesByInstructorId(id);
		System.out.println("Courses: " + courses);
	}

	private void findInstructorWithCourses(IDAO appDAO) {
		int id = 1;
		System.out.println("Finding instructor id: " + id);

		Instructor temp = appDAO.findInstructorById(id);
		System.out.println("Instructor: " + temp);
		System.out.println("Courses: " + temp.getCourses());
	}

	private void createIntrusctorWithCourses(IDAO appDAO) {
		Instructor temp = new Instructor("Luigi","Cheesecake","luigi@luv2code.com");
		InstructorDetail details = new InstructorDetail("youtube", "luv 2 code!");

		// associate the objects
		temp.setInstructorDetail(details);
		// save the instructor

		Course course1 = new Course("Math - The depths of algebra");
		Course course2 = new Course("History - Origins of Saddam Hussein");

		temp.add(course1);
		temp.add(course2);
		
		System.out.println("Saving instructor: " + temp);
		System.out.println("The courses: " + temp.getCourses());
		appDAO.save(temp);

	
		System.out.println("===>> Done");
	}

	private void deleteInstructorDetail(IDAO appDAO) {
		int id = 1;
		
		System.out.println("===>> Delete instructor detail id " + id + " done");
		appDAO.delete(id);
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
