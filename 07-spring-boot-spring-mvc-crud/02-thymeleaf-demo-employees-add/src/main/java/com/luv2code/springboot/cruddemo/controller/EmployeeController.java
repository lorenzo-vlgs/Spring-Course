package com.luv2code.springboot.cruddemo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.luv2code.springboot.cruddemo.entity.Employee;
import com.luv2code.springboot.cruddemo.service.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }  
    
    // add mapping for "/list"
    @GetMapping("/list")
    public String listEmployees(Model model){
        
        // get the employees from db
        List<Employee> result = employeeService.findAll();
        // add to spring model
        model.addAttribute("employees", result);

        return "employees/list-employees";
    }

    @GetMapping("/saveForm")
    public String saveForm(Model model){

        Employee employee = new Employee();
        model.addAttribute("employee", employee);

        return "employees/employee-form";
    }

    @GetMapping("/updateForm")
    public String updateForm(@RequestParam("employeeId") int id,Model model){
        
        Employee employee = employeeService.findById(id);
        model.addAttribute("employee", employee);

        return "employees/employee-form";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("employeeId") int id){
        employeeService.deleteById(id);
        return "redirect:/employees/list";
    } 
    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee employee){
        // save the employee
        employeeService.save(employee);

        // use a redirect to prevent duplicate submissions
        return "redirect:/employees/list";
    }
}
