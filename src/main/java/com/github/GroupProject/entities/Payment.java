package com.github.GroupProject.entities;

import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;

@Entity
public class Payment {

    private String UUID;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Transaction transaction;
    @ManyToOne
    private EBP ebp;


    public String getUUID() {
        return UUID;
    }

    public void setUUID(String UUID) {
        this.UUID = UUID;
    }

    public Long getId() {
        return id;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    public EBP getEbp() {
        return ebp;
    }

    public void setEbp(EBP ebp) {
        this.ebp = ebp;
    }

}
