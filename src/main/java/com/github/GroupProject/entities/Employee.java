package com.github.GroupProject.entities;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Entity
public class Employee extends BaseEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    @ManyToOne(optional = false)
    private User user;
    @OneToMany(mappedBy = "employee")
    private Set<EBP> ebps;




    public void setUser(User user) {
        this.user = user;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }



    public void setEbps(Set<EBP> ebps) {
        this.ebps = ebps;
    }


    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public User getUser() {
        return user;
    }

    public Set<EBP> getEbps() {
        return ebps;
    }
}
