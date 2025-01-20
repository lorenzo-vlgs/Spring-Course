package com.example.luv2code.cruddemo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.luv2code.cruddemo.entities.Course;
import com.example.luv2code.cruddemo.entities.Instructor;
import com.example.luv2code.cruddemo.entities.InstructorDetail;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
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

    @Override
    public InstructorDetail findInstructorDetailById(int id) {
       return entityManager.find(InstructorDetail.class, id);
    }

    @Override
    @Transactional
    public void deleteInstructorDetail(int id) {
       InstructorDetail temp = this.findInstructorDetailById(id);

        entityManager.remove(temp);
    }

    @Override
    public List<Course> findCoursesByInstructorId(int idInstructor) {
        TypedQuery<Course> query = entityManager.createQuery("from Course where instructor.id=:data", Course.class);
        query.setParameter("data",idInstructor);

        List<Course> result = query.getResultList();
        
        return result;
    }

    @Override
    public Instructor findInstructorWithCourses(int id) {
        TypedQuery<Instructor> query = entityManager.createQuery("select i from Instructor i JOIN FETCH i.courses where i.id = :data", Instructor.class);
    
        query.setParameter("data", id);

        return query.getSingleResult();
    }

    @Override
    @Transactional
    public void updateInstructor(Instructor instructor) {
        entityManager.merge(instructor);
    }

    @Override
    @Transactional
    public void updateCourse(Course course) {
        entityManager.merge(course);
    }

    @Override
    public Course findCourseById(int id) {
        return entityManager.find(Course.class, id);


    }

    @Override
    public void deleteCourseById(int id) {
        
        Course course = entityManager.find(Course.class, id);

        entityManager.remove(course);
    }

}