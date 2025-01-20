package com.luv2code.demo.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.demo.entities.Student;
import com.luv2code.demo.entities.StudentErrorResponse;
import com.luv2code.demo.exceptions.StudentNotFoudException;

import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("/api")
public class StudentController {
    
    private List<Student> students;
    //define endpoint for "/students" - return a list of students

    public StudentController(){}

    @PostConstruct
    public void loadData(){
        students = new ArrayList<>();
        
        students.add(new Student("Mario", "Biscotti"));
        students.add(new Student("Luigi", "Cheesecake"));
        students.add(new Student("Samuele", "Pacifici"));
    }

    @GetMapping("/students")
    public List<Student> getStudents(){
        return students;
    } 

    @GetMapping("/students/{studentId}") //le variabili devono avere lo stesso nome del path variable
    public Student getStudent(@PathVariable int studentId){

        //check the studentId again list size
        if (studentId >= students.size() || studentId < 0) {
            throw new StudentNotFoudException("Student id not found - " + studentId);
        } 

        return students.get(studentId);
    }


    // Add an exception handler using @ExceptionHandler
    @ExceptionHandler(StudentNotFoudException.class)
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoudException exc){

        //create a StudentErrorResponse
        StudentErrorResponse error = new StudentErrorResponse();
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    // Add a global exception handler
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(Exception exc){
        
        //create a StudentErrorResponse
        StudentErrorResponse error = new StudentErrorResponse();
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}



