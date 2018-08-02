package com.github.groupproject.repository;

import com.github.groupproject.entities.Payment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface PaymentRepository extends CrudRepository<Payment, Long>{

    Set<Payment> findAllBy ();



}
