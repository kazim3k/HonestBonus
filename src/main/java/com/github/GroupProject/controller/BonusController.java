package com.github.GroupProject.controller;

import com.github.GroupProject.service.BonusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/bonuses")
public class BonusController {

    private BonusService bonusService;

    @Autowired
    public BonusController(BonusService bonusService) {
        this.bonusService = bonusService;
    }

    @PostMapping
    public void create(@RequestParam String name,
                       @RequestParam Double shareOfTransaction,
                       @RequestParam String userUuid) {
        bonusService.create(name,shareOfTransaction,userUuid);
    }
}