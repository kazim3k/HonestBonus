package com.github.groupproject.repository;

import com.github.groupproject.entities.Payment;
import com.github.groupproject.entities.Transaction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface PaymentRepository extends CrudRepository<Payment, Long>{
    Payment findOneByUuid(String paymentUuid);
    Set<Payment> findAllBy ();



}
