package com.github.GroupProject.service;

import com.github.GroupProject.dto.BonusDto;

import java.util.Set;

public interface BonusService {

    void create(String name, Double shareOfTransaction, String userUuid);

    Set<BonusDto> findAll();
}

