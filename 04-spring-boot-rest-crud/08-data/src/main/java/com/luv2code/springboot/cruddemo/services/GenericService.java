package com.luv2code.springboot.cruddemo.services;

import java.util.List;

public interface GenericService<E>{

    List<E> findAll();
    
    E findById(int id);

    E save(E e);

    void deleteById(int id);
}
