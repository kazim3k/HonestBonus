package com.github.groupproject.controller;

import com.github.groupproject.dto.ClientDto;
import com.github.groupproject.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api/clients")
public class ClientController {

    private ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping
    public void create(@RequestParam String clientName,
                       @RequestParam String userUuid) {
        clientService.create(clientName,userUuid);
    }

    @GetMapping
    public Set<ClientDto> findAll(){
        return clientService.findAll();
    }
}
