package com.github.GroupProject.dto;

import com.github.GroupProject.entities.Client;
import com.github.GroupProject.entities.User;

public class ClientDto {

    private String uuid;
    private String clientName;
    private String companyName;

    public ClientDto(String uuid, String clientName, String companyName) {
        this.uuid = uuid;
        this.clientName = clientName;
        this.companyName = companyName;
    }

    public ClientDto ( Client client) {
        this.uuid = client.getUuid();
        this.clientName = client.getClientName();
        this.companyName = client.getUser().getCompanyName();
    }

    public String getUuid() {
        return uuid;
    }

    public String getClientName() {
        return clientName;
    }

    public String getCompanyName() {
        return companyName;
    }
}
