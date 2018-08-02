package com.github.GroupProject.controller;

import com.github.GroupProject.dto.UserDto;
import com.github.GroupProject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("api/users")
public class UserController {


    private UserService userService;

    @Autowired
    public UserController(UserService userservice) {
        this.userService = userservice;
    }


    @PostMapping
    public void create(@RequestParam String companyName, @RequestParam String email){
    userService.create(companyName, email);
    }

    @GetMapping
    public Set<UserDto> findAll(){
        return userService.findAll();
    }



}
