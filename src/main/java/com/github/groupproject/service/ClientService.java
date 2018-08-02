package com.github.groupproject.service;

import com.github.groupproject.dto.ClientDto;

import java.util.Set;


public interface ClientService {
    void create(String clientName, String userUuid);

    Set<ClientDto> findAll();
}
