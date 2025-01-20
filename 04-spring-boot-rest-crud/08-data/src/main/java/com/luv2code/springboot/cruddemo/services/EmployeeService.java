package com.luv2code.springboot.cruddemo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luv2code.springboot.cruddemo.entities.Employee;
import com.luv2code.springboot.cruddemo.repositories.EmployeeRepository;

@Service
public class EmployeeService implements GenericService<Employee>{

    private EmployeeRepository employeeRepository;

    
    public EmployeeService() {
    }

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int id) {
        return employeeRepository.findById(id).get();
    }

    @Override
    public Employee save(Employee e) {
        return employeeRepository.save(e);
    }

    @Override
    public void deleteById(int id) {
        employeeRepository.deleteById(id);
    }
    
}
