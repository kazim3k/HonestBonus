package com.github.groupproject.service.impl;

import com.github.groupproject.entities.Payment;
import com.github.groupproject.repository.EBPRepository;
import com.github.groupproject.repository.PaymentRepository;
import com.github.groupproject.repository.TransactionRepository;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PaymentServiceImplTest {


    @Autowired
    private EBPRepository ebpRepository;
    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private PaymentRepository paymentRepository;
    @Test
    public void whenCreatingPayment_ThenPaymentExist() {

        PaymentServiceImpl paymentService = new PaymentServiceImpl(paymentRepository,
                                                transactionRepository,ebpRepository);

        String paymentUuid = paymentService.create("uuid4","uuid5");
        Payment payment = paymentRepository.findOneByUuid(paymentUuid);
        Assertions.assertThat(payment)
                .isNotNull()
                .hasFieldOrPropertyWithValue("transaction",transactionRepository.
                        findOneByUuid("uuid4"))
                .hasFieldOrPropertyWithValue("ebp",ebpRepository.
                        findOneByUuid("uuid5"));

    }
}
