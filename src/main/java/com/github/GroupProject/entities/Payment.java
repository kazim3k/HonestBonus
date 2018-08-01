package com.github.GroupProject.entities;

public class Payment {

    private String UUID;
    private Long id;
    private Transaction transaction;
    private EBP epb;
    private Employee employee;

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

    public EBP getEpb() {
        return epb;
    }

    public void setEpb(EBP epb) {
        this.epb = epb;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
