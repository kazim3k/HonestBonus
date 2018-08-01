package com.github.GroupProject.service.Impl;

import com.github.GroupProject.entities.User;
import com.github.GroupProject.repository.UserRepository;
import com.github.GroupProject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;


public class UserServicelmpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServicelmpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }



    @Override
    public void create(String companyName, String email) {
        User user = new User();
        user.getCompanyName(companyName);
        user.setEmail(email);
        userRepository.save(user);

    }
}
