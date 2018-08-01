package com.github.GroupProject.entities;

public class Client {

    private Long Id;
    private String UUID;

    private String clientName;
    private Long userId;
    //private Set<Transactions> transactions;
    //private Set<EBP> ebps;


    public Client() {
    }

    public Client(String UUID, Long id, String clientName, Long userId) {
        this.UUID = UUID;
        Id = id;
        this.clientName = clientName;
        this.userId = userId;
    }

    public String getUUID() {
        return UUID;
    }

    public void setUUID(String UUID) {
        this.UUID = UUID;
    }

    public Long getId() {
        return Id;
    }


    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
