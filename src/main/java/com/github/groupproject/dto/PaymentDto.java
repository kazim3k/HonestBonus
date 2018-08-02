package com.github.groupproject.dto;

import com.github.groupproject.entities.Payment;

public class PaymentDto {

    private String uuid;
    private String employeeEmail;
    private String bonusName;
    private String clientName;

    public PaymentDto(Payment payment) {
        this.uuid = payment.getUuid();
        this.employeeEmail = payment.getEbp().getEmployee().getEmail();
        this.bonusName = payment.getEbp().getBonus().getName();
        this.clientName = payment.getEbp().getClient().getClientName();

    }

    public String getUuid() {
        return uuid;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public String getBonusName() {
        return bonusName;
    }

    public String getClientName() {
        return clientName;
    }
}
