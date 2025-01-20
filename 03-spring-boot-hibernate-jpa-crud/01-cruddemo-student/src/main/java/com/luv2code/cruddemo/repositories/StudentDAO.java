package com.luv2code.cruddemo.repositories;

import java.util.List;

import com.luv2code.cruddemo.entities.Student;

public interface StudentDAO {
    
    void save(Student student);

    Student find(Integer id);

    List<Student> findAll();

    List<Student> findByLastname(String lastname);

    void update(Student student);

    void delete(Integer id);

    int deleteAll();
}
