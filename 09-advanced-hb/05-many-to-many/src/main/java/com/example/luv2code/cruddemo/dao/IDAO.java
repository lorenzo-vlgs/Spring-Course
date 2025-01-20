package com.example.luv2code.cruddemo.dao;

import java.util.List;

import com.example.luv2code.cruddemo.entities.Course;
import com.example.luv2code.cruddemo.entities.Instructor;
import com.example.luv2code.cruddemo.entities.InstructorDetail;
import com.example.luv2code.cruddemo.entities.Student;

public interface IDAO {
    
    void save(Instructor instructor);

    Instructor findInstructorById(int id);

    void delete(int id);
    
    InstructorDetail findInstructorDetailById(int id);

    void deleteInstructorDetail(int id);

    List<Course> findCoursesByInstructorId(int idInstructor);

    Instructor findInstructorWithCourses(int id);

    void updateInstructor(Instructor instructor);

    void updateCourse(Course course);

    Course findCourseById(int id);
    
    void deleteCourseById(int id);

    void save(Course course);

    Course findCourseAndReviewsById(int id);

    Course findCourseAndStudentsById(int id);

    Student findStudentAndCoursesById(int id);
}
