package com.github.GroupProject.entities;

public class Employee {
    private String UUID;
    private Long Id;
    private String firstName;
    private String lastName;
    private String email;
    private Long idUser;
//    private Set<Payment> payments;
//    private Set<EBP> ebps;

    public void setUUID(String UUID) {
        this.UUID = UUID;
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

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

//    public void setPayments(Set<Payment> payments) {
//        this.payments = payments;
//    }
//
//    public void setEbps(Set<EBP> ebps) {
//        this.ebps = ebps;
//    }


    public String getUUID() {
        return UUID;
    }

    public Long getId() {
        return Id;
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

    public Long getIdUser() {
        return idUser;
    }


}
