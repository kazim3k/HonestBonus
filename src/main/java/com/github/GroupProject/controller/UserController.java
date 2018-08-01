package com.github.GroupProject.controller;

import com.github.GroupProject.entities.User;
import com.github.GroupProject.service.Impl.UserServicelmpl;
import com.github.GroupProject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/users")
public class UserController {


    private UserService userservice;
    @Autowired
    public UserController(UserService userservice) {
        this.userservice = userservice;
    }


    @PostMapping
    public void create(@RequestParam String companyName, @RequestParam String email){
    userservice.create(companyName, email);

    }




}
