package com.github.GroupProject.service.Impl;

import com.github.GroupProject.entities.Employee;
import com.github.GroupProject.repository.EmployeeRepository;
import com.github.GroupProject.repository.UserRepository;
import com.github.GroupProject.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private UserRepository userRepository;
    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(UserRepository userRepository, EmployeeRepository employeeRepository) {
        this.userRepository = userRepository;
        this.employeeRepository = employeeRepository;
    }

    @Override
    public void create(String firstName, String lastName, String email, String userUuid) {
        Employee employee = new Employee();
        employee.setFirstName(firstName);
        employee.setLastName(lastName);
        employee.setEmail(email);
        employee.setUser(userRepository.findOneByUuid(userUuid));
        employeeRepository.save(employee);
    }
}
