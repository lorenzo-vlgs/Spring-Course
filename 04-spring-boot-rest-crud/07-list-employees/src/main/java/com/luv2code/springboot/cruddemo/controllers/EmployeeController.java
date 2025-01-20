package com.luv2code.springboot.cruddemo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springboot.cruddemo.entities.Employee;
import com.luv2code.springboot.cruddemo.services.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {
    
    private EmployeeService employeeService;

    public EmployeeController() {
    }

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeService.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee findById(@PathVariable int employeeId){
        Employee e = employeeService.findById(employeeId);

        if (e == null) {
            throw new RuntimeException("Employee id not found - " + employeeId);
        }

        return e;
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee e){
        e.setId(0);

        Employee employee = employeeService.save(e);
        return employee;
    }

    @PutMapping("/employees")
    public Employee putEmployee(@RequestBody Employee e){
        Employee employee = employeeService.save(e);
        return employee;
    }

    @DeleteMapping("/employees/{employeeId}")
    public void deleteEmployee(@PathVariable int employeeId){
        employeeService.deleteById(employeeId);
    }
}
