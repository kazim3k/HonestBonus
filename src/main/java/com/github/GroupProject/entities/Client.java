package com.github.GroupProject.entities;

public class Client {

    private Long Id;
    private String UUID;
    private String clientName;
    private User userId;

    //private Set<Transactions> transactions;
    //private Set<EBP> ebps;

    public Client() {
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
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
}
