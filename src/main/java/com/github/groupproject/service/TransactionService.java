package com.github.groupproject.service;

import com.github.groupproject.dto.TransactionDto;
import com.github.groupproject.entities.Transaction;

import java.util.Set;

public interface TransactionService {
    String create(String clientUuid);
    Set<TransactionDto> findAll();
    Set<TransactionDto> findAllByClientUuid(String clientUuid);
    Set<TransactionDto> findAllByClientUserUuid(String userUuid);

}
