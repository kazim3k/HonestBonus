package com.github.groupproject.controller;

import com.github.groupproject.dto.UserDto;
import com.github.groupproject.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("api/users")
@Api(value = "User HB" , description = "user requests")
public class UserController {


    private UserService userService;

    @Autowired
    public UserController(UserService userservice) {
        this.userService = userservice;
    }


    @PostMapping
    @ApiOperation(value = "Add User")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Successful user added")})
    public void create(@RequestParam String companyName, @RequestParam String email){
    userService.create(companyName, email);
    }

    @GetMapping
    @ApiOperation(value = "Return User")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Successful - users found"),
                           @ApiResponse(code = 500, message = "Unsuccessful - user not found")})
    public Set<UserDto> findAll(){
        return userService.findAll();
    }



}
