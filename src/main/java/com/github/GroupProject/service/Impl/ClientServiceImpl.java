package com.github.GroupProject.service.Impl;

import com.github.GroupProject.dto.ClientDto;
import com.github.GroupProject.entities.Client;
import com.github.GroupProject.repository.ClientRepository;
import com.github.GroupProject.repository.UserRepository;
import com.github.GroupProject.service.ClientService;
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
    public void create(String clientName, String userUuid) {
        Client client = new Client();
        client.setClientName(clientName);
        client.setUser(userRepository.findOneByUuid(userUuid));
        clientRepository.save(client);
    }

    @Override
    public Set<ClientDto> findAll() {
        return clientRepository.findAllBy().stream()
                .map(ClientDto::new)
                .collect(Collectors.toSet());
    }
}
