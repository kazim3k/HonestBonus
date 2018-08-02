package com.github.GroupProject.controller;

import com.github.GroupProject.dto.EBPDto;
import com.github.GroupProject.service.EBPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api/ebps")
public class EBPController {

    private EBPService ebpService;

    @Autowired
    public EBPController(EBPService ebpService) {
        this.ebpService = ebpService;
    }

    @PostMapping
    public void create(@RequestParam String bonusUuid,
                       @RequestParam String emloyeeUuid,
                       @RequestParam String clientUuid){
        ebpService.create(bonusUuid,emloyeeUuid,clientUuid);
    }

    @GetMapping
    public Set<EBPDto> findAll() {
        return ebpService.findAll();
    }
}
