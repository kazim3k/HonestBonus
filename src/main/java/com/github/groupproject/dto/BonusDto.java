package com.github.groupproject.dto;

import com.github.groupproject.entities.Bonus;

public class BonusDto {

    private String uuid;
    private String name;
    private Double shareOfTransaction;
    private Integer timeOutInDays;
    private String companyName;

    public BonusDto(String uuid, String name, Double shareOfTransaction, Integer timeOutInDays, String companyName) {
        this.uuid = uuid;
        this.name = name;
        this.shareOfTransaction = shareOfTransaction;
        this.timeOutInDays = timeOutInDays;
        this.companyName = companyName;
    }

    public BonusDto (Bonus bonus) {
        this.uuid = bonus.getUuid();
        this.name = bonus.getName();
        this.shareOfTransaction = bonus.getShareOfTransaction();
        this.timeOutInDays = bonus.getTimeOutInDays();
        this.companyName = bonus.getUser().getCompanyName();
    }

    public String getUuid() {
        return uuid;
    }

    public String getName() {
        return name;
    }

    public Double getShareOfTransaction() {
        return shareOfTransaction;
    }

    public String getCompanyName() {
        return companyName;
    }

    public Integer getTimeOutInDays() {
        return timeOutInDays;
    }
}
