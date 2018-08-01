package com.github.GroupProject.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Bonus {

    private String UUID;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private Double percentOfTransaction;
    @ManyToOne
    private User user;
    @OneToMany(mappedBy = "bonus")
    private Set<EBP> ebps;

    public String getUUID() {
        return UUID;
    }

    public void setUUID(String UUID) {
        this.UUID = UUID;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPercentOfTransaction() {
        return percentOfTransaction;
    }

    public void setPercentOfTransaction(Double percentOfTransaction) {
        this.percentOfTransaction = percentOfTransaction;
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
