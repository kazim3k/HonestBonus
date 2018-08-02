package com.github.groupproject.service;

import com.github.groupproject.dto.PaymentDto;

import java.util.Set;

public interface PaymentService {
    void create(String transactionUuid, String ebpUuid);

    Set<PaymentDto> findAll();

}
