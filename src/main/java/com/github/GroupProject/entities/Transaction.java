package com.github.GroupProject.entities;

import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Transaction {

    private String UUID;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private Client client;
    @OneToMany(mappedBy = "transaction")
    private Set<Payment> payments;


    public Set<Payment> getPayments() {
        return payments;
    }

    public void setPayments(Set<Payment> payments) {
        this.payments = payments;
    }

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
