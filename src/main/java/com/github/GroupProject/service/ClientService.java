package com.github.GroupProject.service;

import org.springframework.stereotype.Service;

@Service
public interface ClientService {
    void create(String clientName, Long userId);
}
