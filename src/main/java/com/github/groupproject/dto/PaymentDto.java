package com.github.groupproject.dto;

import com.github.groupproject.entities.Payment;

import java.math.BigDecimal;

public class PaymentDto {

    private String uuid;
    private String employeeEmail;
    private String bonusName;
    private String clientName;
    private BigDecimal paycheck;

    public PaymentDto(String uuid, String employeeEmail,
                      String bonusName, String clientName, BigDecimal paycheck) {
        this.uuid = uuid;
        this.employeeEmail = employeeEmail;
        this.bonusName = bonusName;
        this.clientName = clientName;
        this.paycheck = paycheck;
    }

    public PaymentDto(Payment payment) {
        this.uuid = payment.getUuid();
        this.employeeEmail = payment.getEbp().getEmployee().getEmail();
        this.bonusName = payment.getEbp().getBonus().getName();
        this.clientName = payment.getEbp().getClient().getClientName();
        this.paycheck = payment.getPaycheck();
    }

    public BigDecimal getPaycheck() {
        return paycheck;
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
