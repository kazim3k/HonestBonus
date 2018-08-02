package com.github.GroupProject.controller;

import com.github.GroupProject.dto.TransactionDto;
import com.github.GroupProject.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public void create(@RequestParam String clientUuid){
        transactionService.create(clientUuid);
    }

    @GetMapping
    public Set<TransactionDto> findAll(){
        return transactionService.findAll();
    }
}
