package com.github.GroupProject.entities;

public class Transaction {

    private Long Id;
    private String UUID;
    private Client client;
    //private Set<Payment> payments;

    public Transaction() {}

    public Long getId() {
        return Id;
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
