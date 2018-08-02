package com.github.GroupProject.entities;



import javax.persistence.*;
import java.util.UUID;

@Entity
public class Payment extends BaseEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Transaction transaction;
    @ManyToOne
    private EBP ebp;


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
