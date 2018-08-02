package com.github.groupproject.service.impl;

import com.github.groupproject.dto.ClientDto;
import com.github.groupproject.entities.Client;
import com.github.groupproject.repository.ClientRepository;
import com.github.groupproject.repository.UserRepository;
import com.github.groupproject.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ClientServiceImpl implements ClientService {

    private ClientRepository clientRepository;
    private UserRepository userRepository;

    @Autowired
    public ClientServiceImpl(ClientRepository clientRepository, UserRepository userRepository) {
        this.clientRepository = clientRepository;
        this.userRepository = userRepository;
    }

    @Override
    public String create(String clientName, String userUuid) {
        Client client = new Client();
        client.setClientName(clientName);
        client.setUser(userRepository.findOneByUuid(userUuid));
        clientRepository.save(client);
        return client.getUuid();
    }

    @Override
    public Set<ClientDto> findAll() {
        return clientRepository.findAllBy().stream()
                .map(ClientDto::new)
                .collect(Collectors.toSet());
    }
}
