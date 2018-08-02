package com.github.GroupProject.service;

import com.github.GroupProject.dto.UserDto;
import org.springframework.stereotype.Service;

import java.util.Set;


public interface UserService {

    void create(String companyName, String email);

    Set<UserDto> findAll();

}