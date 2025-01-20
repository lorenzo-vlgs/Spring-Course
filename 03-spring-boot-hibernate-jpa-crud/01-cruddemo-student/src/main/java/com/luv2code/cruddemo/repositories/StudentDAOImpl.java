package com.luv2code.cruddemo.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.cruddemo.entities.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class StudentDAOImpl implements StudentDAO{

    private EntityManager entityManager;

    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Student student) {
        entityManager.persist(student); //saves the student
    }

    @Override
    public Student find(Integer id) {
       return entityManager.find(Student.class, id); // get a student by their id
    }

    @Override
    public List<Student> findAll() {
        TypedQuery<Student> query = entityManager.createQuery("FROM Student s ORDER BY s.lastname", Student.class);
        List<Student> result = query.getResultList();

        return result;
    }

    @Override
    public List<Student> findByLastname(String lastname) {
        TypedQuery<Student> query = entityManager.createQuery("FROM Student s WHERE s.lastname=:data", Student.class);
        query.setParameter("data", lastname);

        return query.getResultList();
    }

    @Override
    @Transactional
    public void update(Student student) {
        entityManager.merge(student);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        Student student = this.find(id);
        entityManager.remove(student);
    }

    @Override
    @Transactional
    public int deleteAll() {
        return entityManager.createQuery("DELETE FROM Student").executeUpdate();
    }
    







}
