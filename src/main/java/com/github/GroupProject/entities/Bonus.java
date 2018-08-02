package com.github.GroupProject.entities;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Entity
public class Bonus extends BaseEntity{


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private Double shareOfTransaction;
    @ManyToOne
    private User user;
    @OneToMany(mappedBy = "bonus")
    private Set<EBP> ebps;



    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getShareOfTransaction() {
        return shareOfTransaction;
    }

    public void setShareOfTransaction(Double shareOfTransaction) {
        this.shareOfTransaction = shareOfTransaction;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<EBP> getEbps() {
        return ebps;
    }

    public void setEbps(Set<EBP> ebps) {
        this.ebps = ebps;
    }
}
