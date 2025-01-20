package com.luv2code.springboot.cruddemo.repositories;

import java.util.List;

public interface GenericDAO<E> {
    
    List<E> findAll();

    E findById(int id);

    E save(E e);

    void deleteById(int id);

}
