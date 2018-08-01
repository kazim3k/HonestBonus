package com.github.GroupProject.service;

import org.springframework.stereotype.Service;

@Service
public interface UserService {

    void create(String companyName, String email);
}