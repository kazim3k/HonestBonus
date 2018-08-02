package com.github.groupproject.service;

import com.github.groupproject.dto.EmployeeDto;

import java.util.Set;

public interface EmployeeService {
    void create(String firstName, String lastName, String email, String userUuid);

    Set<EmployeeDto> findAll();
}
