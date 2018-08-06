package com.github.groupproject.controller;

import com.github.groupproject.dto.ClientDto;
import com.github.groupproject.dto.EBPDto;
import com.github.groupproject.service.EBPService;
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

    @GetMapping("byUser_/{userUuid}")
    public Set<EBPDto> findAllByClientUserUuid(@PathVariable String userUuid){
        return ebpService.findAllByClientUserUuid(userUuid);
    }

    @GetMapping("byEmployee_/{employeeUuid}")
    public Set<EBPDto> findAllByEmployeeUuid(@PathVariable String employeeUuid){
        return ebpService.findAllByEmployeeUuid(employeeUuid);
    }
}
