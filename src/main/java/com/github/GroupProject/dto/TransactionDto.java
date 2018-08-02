package com.github.GroupProject.dto;

import com.github.GroupProject.entities.Transaction;

public class TransactionDto {

    private String uuid;
    private String clientName;

    public TransactionDto(String uuid, String clientName) {
        this.uuid = uuid;
        this.clientName = clientName;
    }

    public TransactionDto(Transaction transaction) {
        this.uuid = transaction.getUuid();
        this.clientName = transaction.getClient().getClientName();
    }

    public String getUuid() {
        return uuid;
    }

    public String getClientName() {
        return clientName;
    }
}
