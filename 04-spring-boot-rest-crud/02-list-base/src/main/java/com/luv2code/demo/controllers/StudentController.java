package com.luv2code.demo.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.demo.entities.Student;

@RestController
@RequestMapping("/api")
public class StudentController {
    
    //define endpoint for "/students" - return a list of students
    @GetMapping("/students")
    public List<Student> getStudents(){

        List<Student> students = new ArrayList<>();
        students.add(new Student("Mario", "Biscotti"));
        students.add(new Student("Luigi", "Cheesecake"));
        students.add(new Student("Samuele", "Pacifici"));

        return students;
    } 



}
