package com.example.luv2code.cruddemo.dao;

import com.example.luv2code.cruddemo.entities.Instructor;
import com.example.luv2code.cruddemo.entities.InstructorDetail;

public interface IDAO {
    
    void save(Instructor instructor);

    Instructor findInstructorById(int id);

    void delete(int id);
    
    InstructorDetail findInstructorDetailById(int id);

    void deleteInstructorDetail(int id);
}
