package com.github.GroupProject.repository;

import com.github.GroupProject.entities.Transaction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends CrudRepository<Transaction, Long>{
    Transaction findOneByUuid(String transactionUuid);
}
