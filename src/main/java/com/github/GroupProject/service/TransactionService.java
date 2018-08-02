package com.github.GroupProject.service;

import com.github.GroupProject.dto.TransactionDto;

import java.util.Set;

public interface TransactionService {
    void create(String clientUuid);
    Set<TransactionDto> findAll();
}
