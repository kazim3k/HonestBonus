package com.github.groupproject.service.impl;

import com.github.groupproject.dto.EmployeeDto;
import com.github.groupproject.entities.Employee;
import com.github.groupproject.repository.EmployeeRepository;
import com.github.groupproject.repository.UserRepository;
import com.github.groupproject.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.rmi.runtime.Log;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    Logger LOG = LoggerFactory.getLogger(ClientServiceImpl.class);

    private UserRepository userRepository;
    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(UserRepository userRepository, EmployeeRepository employeeRepository) {
        this.userRepository = userRepository;
        this.employeeRepository = employeeRepository;
    }

    @Override
    public String create(String firstName, String lastName, String email, String userUuid) {
        LOG.info("create Employee: "+firstName);
        Employee employee = new Employee();
        employee.setFirstName(firstName);
        employee.setLastName(lastName);
        employee.setEmail(email);
        employee.setUser(userRepository.findOneByUuid(userUuid));
        employeeRepository.save(employee);
        return employee.getUuid();
    }

    @Override
    public Set<EmployeeDto> findAll() {
        return employeeRepository.findAllBy().stream()
                .map(EmployeeDto::new)
                .collect(Collectors.toSet());

    }
}
