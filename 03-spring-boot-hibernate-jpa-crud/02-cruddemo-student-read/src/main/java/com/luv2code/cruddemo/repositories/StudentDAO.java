package com.luv2code.cruddemo.repositories;

import com.luv2code.cruddemo.entities.Student;

public interface StudentDAO {
    
    void save(Student student);

    Student find(Integer id);
}
