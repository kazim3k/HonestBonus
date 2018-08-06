package com.github.groupproject.service.impl;

import com.github.groupproject.entities.Transaction;
import com.github.groupproject.repository.ClientRepository;
import com.github.groupproject.repository.TransactionRepository;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class TransactionServiceImplTest {


    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private TransactionRepository transactionRepository;
    @Test
    public void whenCreatingTransaction_ThenTransactionExist() {

        TransactionServiceImpl transactionService = new TransactionServiceImpl(transactionRepository,
                                                    clientRepository);

        String transactionUuid = transactionService.create("uuid1");

        Transaction transaction = transactionRepository.findOneByUuid(transactionUuid);
        Assertions.assertThat(transaction)
                .isNotNull()
                .hasFieldOrPropertyWithValue("client",
                                                clientRepository.findOneByUuid("uuid1"));

    }
}
