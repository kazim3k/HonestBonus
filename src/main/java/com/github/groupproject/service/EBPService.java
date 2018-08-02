package com.github.groupproject.service;

import com.github.groupproject.dto.EBPDto;

import java.util.Set;

public interface EBPService {
    void create(String bonusUuid, String employeeUuid, String clientUuid);
    Set<EBPDto> findAll();
}
