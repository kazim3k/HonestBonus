package com.github.GroupProject.entities;

public class Payment {

    private String UUID;
    private Long iD;
    private Long idTransaction;
    //private EBP epb;
    private Long idEmployee;

    public void setUUID(String UUID) {
        this.UUID = UUID;
    }

    public void setIdTransaction(Long idTransaction) {
        this.idTransaction = idTransaction;
    }

//    public void setEBP(EBP epb) {
//        this.epb = epb;
//    }

    public void setIdEmployee(Long idEmployee) {
        this.idEmployee = idEmployee;
    }

    public String getUUID() {
        return UUID;
    }

    public Long getiD() {
        return iD;
    }

    public Long getIdTransaction() {
        return idTransaction;
    }

//    public Long getEBP() {
//        return epb;
//    }

    public Long getIdEmployee() {
        return idEmployee;
    }
}
