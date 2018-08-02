package com.github.GroupProject.service;

import com.github.GroupProject.dto.EBPDto;

import java.util.Set;

public interface EBPService {
    void create(String bonusUuid, String employeeUuid, String clientUuid);
    Set<EBPDto> findAll();
}
