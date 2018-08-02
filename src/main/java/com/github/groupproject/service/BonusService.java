package com.github.groupproject.service;

import com.github.groupproject.dto.BonusDto;

import java.util.Set;

public interface BonusService {

    String create(String name, Double shareOfTransaction, String userUuid);

    Set<BonusDto> findAll();
}

