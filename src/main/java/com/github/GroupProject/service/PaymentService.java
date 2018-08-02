package com.github.GroupProject.service;

import com.github.GroupProject.dto.PaymentDto;

import java.util.Set;

public interface PaymentService {
    void create(String transactionUuid, String ebpUuid);

    Set<PaymentDto> findAll();

}
