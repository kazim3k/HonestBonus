package com.github.GroupProject.entities;

import java.util.Set;

public class Client {

    private Long id;
    private String UUID;
    private String clientName;
    private User user;
    private Set<Transaction> transactions;
    private Set<EBP> ebps;

    public Client() {
    }

    public Set<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(Set<Transaction> transactions) {
        this.transactions = transactions;
    }

    public Set<EBP> getEbps() {
        return ebps;
    }

    public void setEbps(Set<EBP> ebps) {
        this.ebps = ebps;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getUUID() {
        return UUID;
    }

    public void setUUID(String UUID) {
        this.UUID = UUID;
    }

    public Long getId() {
        return id;
    }


    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }
}
