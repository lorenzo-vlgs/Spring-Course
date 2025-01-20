package com.example.luv2code.cruddemo.dao;

import com.example.luv2code.cruddemo.entities.Instructor;

public interface IDAO {
    
    void save(Instructor instructor);

    Instructor findInstructorById(int id);

    void delete(int id);
    
}
