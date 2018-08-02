package com.github.groupproject.service;

import com.github.groupproject.dto.TransactionDto;

import java.util.Set;

public interface TransactionService {
    void create(String clientUuid);
    Set<TransactionDto> findAll();
}
