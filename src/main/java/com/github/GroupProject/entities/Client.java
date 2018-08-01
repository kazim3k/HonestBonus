package com.github.GroupProject.entities;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Entity
public class Client {


    private String uuid = UUID.randomUUID().toString();
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String clientName;
    @ManyToOne
    private User user;
    @OneToMany(mappedBy = "client")
    private Set<Transaction> transactions;
    @OneToMany(mappedBy = "client")
    private Set<EBP> ebps;



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

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
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
