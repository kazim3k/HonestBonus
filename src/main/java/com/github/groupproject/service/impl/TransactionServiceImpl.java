package com.github.groupproject.service.impl;

import com.github.groupproject.dto.TransactionDto;
import com.github.groupproject.entities.Transaction;
import com.github.groupproject.repository.ClientRepository;
import com.github.groupproject.repository.TransactionRepository;
import com.github.groupproject.service.TransactionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.rmi.runtime.Log;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class TransactionServiceImpl implements TransactionService{

    Logger LOG = LoggerFactory.getLogger(ClientServiceImpl.class);

    private TransactionRepository transactionRepository;
    private ClientRepository clientRepository;

    @Autowired
    public TransactionServiceImpl(TransactionRepository transactionRepository,
                                  ClientRepository clientRepository) {
        this.transactionRepository = transactionRepository;
        this.clientRepository = clientRepository;

    }

    @Override
    public String create(String clientUuid) {
        LOG.info("Created Transaction: [clientUuid]: "+ clientUuid);
        Transaction transaction = new Transaction();
        transaction.setClient(clientRepository.findOneByUuid(clientUuid));
        transactionRepository.save(transaction);
        return transaction.getUuid();
    }

    @Override
    public Set<TransactionDto> findAll() {
        return transactionRepository.findAllBy().stream()
                .map(TransactionDto::new)
                .collect(Collectors.toSet());
    }
}
