package com.github.GroupProject.service;

import com.github.GroupProject.dto.ClientDto;
import com.github.GroupProject.dto.UserDto;
import org.springframework.stereotype.Service;

import java.util.Set;


public interface ClientService {
    void create(String clientName, String userUuid);

    Set<ClientDto> findAll();
}
