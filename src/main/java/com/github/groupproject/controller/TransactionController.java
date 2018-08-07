package com.github.groupproject.controller;

import com.github.groupproject.dto.ClientDto;
import com.github.groupproject.dto.TransactionDto;
import com.github.groupproject.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Set;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    private TransactionService transactionService;

    @Autowired
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping
    public void create(@RequestParam String clientUuid, @RequestParam BigDecimal amountOfTransaction){
        transactionService.create(clientUuid,amountOfTransaction);
    }

    @GetMapping
    public Set<TransactionDto> findAll(){
        return transactionService.findAll();
    }

    @GetMapping("/byClient_{clientUuid}")
    public Set<TransactionDto> findAllByClientUuid(@PathVariable String clientUuid){
        return transactionService.findAllByClientUuid(clientUuid);
    }

    @GetMapping("/byUser_{userUuid}")
    public Set<TransactionDto> findAllByClientUserUuid(@PathVariable String userUuid){
        return transactionService.findAllByClientUserUuid(userUuid);
    }
}
