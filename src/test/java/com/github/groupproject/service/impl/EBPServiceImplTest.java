package com.github.groupproject.service.impl;

import com.github.groupproject.entities.EBP;
import com.github.groupproject.entities.Transaction;
import com.github.groupproject.repository.*;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class EBPServiceImplTest {

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
    @Test
    public void whenCreatingEBP_ThenEBPExist() {

        UserServiceImpl userService = new UserServiceImpl(userRepository);
        ClientServiceImpl clientService = new ClientServiceImpl(clientRepository, userRepository);
        EmployeeServiceImpl employeeService = new EmployeeServiceImpl(userRepository,
                                                    employeeRepository);
        BonusServiceImpl bonusService = new BonusServiceImpl(bonusRepository, userRepository);
        EBPServiceImpl ebpService = new EBPServiceImpl(ebpRepository,bonusRepository,
                                                employeeRepository, clientRepository);

        String userUuid = userService.create("Brand24","bran@24.pl");
        String clientUuid = clientService.create("Microsoft",userUuid);
        String emplyeeUuid =employeeService.create("Michal","Kowalski",
                "kowalski@24.pl",userUuid);
        String bonustUuid = bonusService.create("1 kontakt",0.05,userUuid);
        String ebpUuid = ebpService.create(bonustUuid,emplyeeUuid,clientUuid);
        EBP ebp = ebpRepository.findOneByUuid(ebpUuid);
        Assertions.assertThat(ebp)
                .isNotNull()
                .hasFieldOrPropertyWithValue("employee",employeeRepository.
                                                    findOneByUuid(emplyeeUuid))
                .hasFieldOrPropertyWithValue("client",clientRepository.
                                                    findOneByUuid(clientUuid))
                .hasFieldOrPropertyWithValue("bonus",bonusRepository.
                                                    findOneByUuid(bonustUuid));





    }
}
