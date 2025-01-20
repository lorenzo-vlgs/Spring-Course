package com.example.luv2code.cruddemo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.luv2code.cruddemo.entities.Instructor;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
public class InstructorDAO implements IDAO{

    private EntityManager entityManager;

    
    public InstructorDAO() {
    }

    @Autowired
    public InstructorDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Instructor instructor) {
        entityManager.persist(instructor);
    }

    @Override
    public Instructor findInstructorById(int id) {
       return entityManager.find(Instructor.class, id);
    }

    @Override
    @Transactional
    public void delete(int id) {
        Instructor temp = this.findInstructorById(id);
        entityManager.remove(temp);
    }
    
}
