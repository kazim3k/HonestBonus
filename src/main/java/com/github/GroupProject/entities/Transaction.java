package com.github.GroupProject.entities;

import java.util.Set;

public class Transaction {

    private String UUID;
    private Long id;
    private Client client;
    private Set<Payment> payments;


    public Long getId() {
        return id;
    }

    public String getUUID() {
        return UUID;
    }

    public void setUUID(String UUID) {
        this.UUID = UUID;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
