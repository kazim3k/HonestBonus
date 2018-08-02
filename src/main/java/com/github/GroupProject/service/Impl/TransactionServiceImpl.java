package com.github.GroupProject.service.Impl;

import com.github.GroupProject.entities.Transaction;
import com.github.GroupProject.repository.ClientRepository;
import com.github.GroupProject.repository.TransactionRepository;
import com.github.GroupProject.repository.UserRepository;
import com.github.GroupProject.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionServiceImpl implements TransactionService{

    private TransactionRepository transactionRepository;
    private ClientRepository clientRepository;

    @Autowired
    public TransactionServiceImpl(TransactionRepository transactionRepository,
                                  ClientRepository clientRepository) {
        this.transactionRepository = transactionRepository;
        this.clientRepository = clientRepository;

    }

    @Override
    public void create(String clientUuid) {
        Transaction transaction = new Transaction();
        transaction.setClient(clientRepository.findOneByUuid(clientUuid));
        transactionRepository.save(transaction);
    }
}
