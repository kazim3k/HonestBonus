package com.github.groupproject.service.impl;

import com.github.groupproject.entities.EBP;
import com.github.groupproject.entities.Payment;
import com.github.groupproject.repository.*;
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
    private UserRepository userRepository;
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private BonusRepository bonusRepository;
    @Autowired
    private EBPRepository ebpRepository;
    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private PaymentRepository paymentRepository;
    @Test
    public void whenCreatingPayment_ThenPaymentExist() {

        UserServiceImpl userService = new UserServiceImpl(userRepository);
        ClientServiceImpl clientService = new ClientServiceImpl(clientRepository, userRepository);
        EmployeeServiceImpl employeeService = new EmployeeServiceImpl(userRepository,
                                                employeeRepository);
        BonusServiceImpl bonusService = new BonusServiceImpl(bonusRepository, userRepository);
        EBPServiceImpl ebpService = new EBPServiceImpl(ebpRepository,bonusRepository,
                                        employeeRepository, clientRepository);
        TransactionServiceImpl transactionService = new TransactionServiceImpl(transactionRepository,
                                                        clientRepository);
        PaymentServiceImpl paymentService = new PaymentServiceImpl(paymentRepository,
                                                transactionRepository,ebpRepository);

        String userUuid = userService.create("Brand24","bran@24.pl");
        String clientUuid = clientService.create("Microsoft",userUuid);
        String transactionUuid = transactionService.create(clientUuid);
        String emplyeeUuid =employeeService.create("Michal","Kowalski",
                "kowalski@24.pl",userUuid);
        String bonustUuid = bonusService.create("1 kontakt",0.05,userUuid);
        String ebpUuid = ebpService.create(bonustUuid,emplyeeUuid,clientUuid);
        String paymnentUuid = paymentService.create(transactionUuid,ebpUuid);

        Payment payment = paymentRepository.findOneByUuid(paymnentUuid);
        Assertions.assertThat(payment)
                .isNotNull()
                .hasFieldOrPropertyWithValue("transaction",transactionRepository.
                        findOneByUuid(transactionUuid))
                .hasFieldOrPropertyWithValue("ebp",ebpRepository.
                        findOneByUuid(ebpUuid));

    }
}
