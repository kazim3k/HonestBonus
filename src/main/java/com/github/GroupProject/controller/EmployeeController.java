package com.github.GroupProject.controller;

import com.github.GroupProject.dto.EmployeeDto;
import com.github.GroupProject.entities.Employee;
import com.github.GroupProject.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    public void create( @RequestParam String firstName,
                        @RequestParam String lastName,
                        @RequestParam String email,
                        @RequestParam String userUuid){
        employeeService.create(firstName, lastName, email, userUuid);
    }

    @GetMapping
    public Set<EmployeeDto> findAll(){
        return employeeService.findAll();
    }
}
