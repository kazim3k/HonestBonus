package com.github.groupproject.service.impl;

import com.github.groupproject.dto.UserDto;
import com.github.groupproject.entities.User;
import com.github.groupproject.repository.UserRepository;
import com.github.groupproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }



    @Override
    public String create(String companyName, String email) {
        User user = new User();
        user.setCompanyName(companyName);
        user.setEmail(email);
        User createdUser = userRepository.save(user);
        return createdUser.getUuid();

    }

    @Override
    public Set<UserDto> findAll() {
        return userRepository.findAllBy().stream()
                .map(UserDto::new)
                .collect(Collectors.toSet());
    }
}
