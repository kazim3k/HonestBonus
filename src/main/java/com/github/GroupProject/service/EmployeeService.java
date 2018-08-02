package com.github.GroupProject.service;

import com.github.GroupProject.dto.EmployeeDto;

import java.util.Set;

public interface EmployeeService {
    void create(String firstName, String lastName, String email, String userUuid);

    Set<EmployeeDto> findAll();
}
