package com.github.groupproject.service.impl;

import com.github.groupproject.entities.Client;
import com.github.groupproject.repository.ClientRepository;
import com.github.groupproject.repository.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ClientServiceImplTest {

    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private UserRepository userRepository;

    @Test
    public void whenCreatingClient_ThenClientExists() {
        ClientServiceImpl clientService = new ClientServiceImpl(clientRepository, userRepository);
        UserServiceImpl userService = new UserServiceImpl(userRepository);

        String userUuid = userService.create("Brand24","bran@24.pl");
        String clientUuid = clientService.create("Microsoft",userUuid);

        Client client = clientRepository.findOneByUuid(clientUuid);
        Assertions.assertThat(client)
                .isNotNull()
                .hasFieldOrPropertyWithValue("clientName", "Microsoft")
                .hasFieldOrPropertyWithValue("user",userRepository.findOneByUuid(userUuid));
    }

    //TODO custom matcher (harmcrest)


}