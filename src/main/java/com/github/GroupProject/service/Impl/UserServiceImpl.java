package com.github.GroupProject.service.Impl;

import com.github.GroupProject.dto.UserDto;
import com.github.GroupProject.entities.User;
import com.github.GroupProject.repository.UserRepository;
import com.github.GroupProject.service.UserService;
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
    public void create(String companyName, String email) {
        User user = new User();
        user.setCompanyName(companyName);
        user.setEmail(email);
        userRepository.save(user);

    }

    @Override
    public Set<UserDto> findAll() {
        return userRepository.findAllBy().stream()
                .map(UserDto::new)
                .collect(Collectors.toSet());
    }
}
