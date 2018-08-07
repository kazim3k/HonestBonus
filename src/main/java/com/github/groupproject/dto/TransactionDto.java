package com.github.groupproject.dto;

import com.github.groupproject.entities.Transaction;

import java.math.BigDecimal;

public class TransactionDto {

    private String uuid;
    private String clientName;
    private BigDecimal amountOfTransaction;

    public TransactionDto(String uuid, String clientName, BigDecimal amountOfTransaction) {
        this.uuid = uuid;
        this.clientName = clientName;
        this.amountOfTransaction = amountOfTransaction;
    }

    public TransactionDto(Transaction transaction) {
        this.uuid = transaction.getUuid();
        this.clientName = transaction.getClient().getClientName();
        this.amountOfTransaction = transaction.getAmountOfTransaction();
    }

    public BigDecimal getAmountOfTransaction() {
        return amountOfTransaction;
    }

    public String getUuid() {
        return uuid;
    }

    public String getClientName() {
        return clientName;
    }
}
