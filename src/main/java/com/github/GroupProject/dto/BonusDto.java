package com.github.GroupProject.dto;

import com.github.GroupProject.entities.Bonus;

public class BonusDto {

    private String uuid;
    private String name;
    private Double shareOfTransaction;
    private String companyName;

    public BonusDto(String uuid, String name, Double shareOfTransaction, String companyName) {
        this.uuid = uuid;
        this.name = name;
        this.shareOfTransaction = shareOfTransaction;
        this.companyName = companyName;
    }

    public BonusDto (Bonus bonus) {
        this.uuid = bonus.getUuid();
        this.name = bonus.getName();
        this.shareOfTransaction = bonus.getShareOfTransaction();
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
}
