package com.github.GroupProject.repository;

import com.github.GroupProject.entities.Payment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface PaymentRepository extends CrudRepository<Payment, Long>{

    Set<Payment> findAllBy ();



}
