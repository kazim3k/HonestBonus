package com.github.groupproject.controller;


import com.github.groupproject.dto.PaymentDto;
import com.github.groupproject.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {
    private PaymentService paymentService;

    @Autowired
    public PaymentController(PaymentService paymentService) { this.paymentService = paymentService; }

    @PostMapping
    public void create (@RequestParam String transactionUuid,
                        @RequestParam String ebpUuid){
        paymentService.create(transactionUuid, ebpUuid);
    }

    @GetMapping
    Set<PaymentDto> findAll (){
         return paymentService.findAll();


    }

}
