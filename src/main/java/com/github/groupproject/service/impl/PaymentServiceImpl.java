package com.github.groupproject.service.impl;

import com.github.groupproject.dto.PaymentDto;
import com.github.groupproject.entities.Payment;
import com.github.groupproject.repository.EBPRepository;
import com.github.groupproject.repository.PaymentRepository;
import com.github.groupproject.repository.TransactionRepository;
import com.github.groupproject.service.PaymentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class PaymentServiceImpl implements PaymentService{

    Logger LOG = LoggerFactory.getLogger(ClientServiceImpl.class);

    private PaymentRepository paymentRepository;
    private TransactionRepository transactionRepository;
    private EBPRepository ebpRepository;

    @Autowired
    public PaymentServiceImpl(PaymentRepository paymentRepository, TransactionRepository transactionRepository, EBPRepository ebpRepository) {
        this.paymentRepository = paymentRepository;
        this.transactionRepository = transactionRepository;
        this.ebpRepository = ebpRepository;
    }

    @Override
    public String create(String transactionUuid, String ebpUuid) {
        LOG.info("Created Payment: "+transactionUuid);
        Payment payment = new Payment();
        payment.setTransaction(transactionRepository.findOneByUuid(transactionUuid));
        payment.setEbp(ebpRepository.findOneByUuid(ebpUuid));
        paymentRepository.save(payment);
        return payment.getUuid();
    }

    @Override
    public Set<PaymentDto> findAll() {
        return paymentRepository.findAllBy().stream()
                .map(PaymentDto :: new )
                .collect(Collectors.toSet());
    }
}
