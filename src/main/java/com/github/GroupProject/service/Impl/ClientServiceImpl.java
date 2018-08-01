package com.github.GroupProject.service.Impl;

import com.github.GroupProject.entities.Client;
import com.github.GroupProject.repository.ClientRepository;
import com.github.GroupProject.repository.UserRepository;
import com.github.GroupProject.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;

public class ClientServiceImpl implements ClientService {

    private ClientRepository clientRepository;
    private UserRepository userRepository;

    @Autowired
    public ClientServiceImpl(ClientRepository clientRepository, UserRepository userRepository) {
        this.clientRepository = clientRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void create(String clientName, Long userId) {
        Client client = new Client();

        client.setClientName(clientName);
        client.setUser(userRepository.findOne(userId));
        clientRepository.save(client);
    }
}
