package com.github.groupproject.controller;

import com.github.groupproject.dto.BonusDto;
import com.github.groupproject.dto.ClientDto;
import com.github.groupproject.service.BonusService;
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
                       @RequestParam Integer timeOutInDays,
                       @RequestParam String userUuid) {
        bonusService.create(name,shareOfTransaction,timeOutInDays,userUuid);
    }

    @GetMapping
    public Set<BonusDto> findAll(){
        return bonusService.findAll();
    }

    @GetMapping("/{userUuid}")
    public Set<BonusDto> findAllByUserUuid(@PathVariable String userUuid){
        return bonusService.findAllByUserUuid(userUuid);
    }
}
