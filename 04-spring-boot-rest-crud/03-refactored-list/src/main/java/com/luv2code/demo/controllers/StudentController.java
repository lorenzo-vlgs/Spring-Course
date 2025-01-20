package com.luv2code.demo.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.demo.entities.Student;

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
        return students.get(studentId);
    }

}
