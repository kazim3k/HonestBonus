package com.github.GroupProject.controller;

import com.github.GroupProject.dto.BonusDto;
import com.github.GroupProject.service.BonusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

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

    @GetMapping
    public Set<BonusDto> findAll(){
        return bonusService.findAll();
    }
}
