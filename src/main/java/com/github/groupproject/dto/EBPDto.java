package com.github.groupproject.dto;

import com.github.groupproject.entities.EBP;

public class EBPDto {

    private String uuid;
    private String bonusName;
    private String employeeEmail;
    private String clientName;

    public EBPDto(String uuid, String bonusName, String employeeEmail, String clientName) {
        this.uuid = uuid;
        this.bonusName = bonusName;
        this.employeeEmail = employeeEmail;
        this.clientName = clientName;
    }

    public EBPDto (EBP ebp) {
        this.uuid = ebp.getUuid();
        this.bonusName = ebp.getBonus().getName();
        this.employeeEmail = ebp.getEmployee().getEmail();
        this.clientName = ebp.getClient().getClientName();
    }

    public String getUuid() {
        return uuid;
    }

    public String getBonusName() {
        return bonusName;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public String getClientName() {
        return clientName;
    }
}
