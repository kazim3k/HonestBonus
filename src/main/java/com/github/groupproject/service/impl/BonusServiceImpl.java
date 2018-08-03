package com.github.groupproject.service.impl;

import com.github.groupproject.dto.BonusDto;
import com.github.groupproject.entities.Bonus;
import com.github.groupproject.repository.BonusRepository;
import com.github.groupproject.repository.UserRepository;
import com.github.groupproject.service.BonusService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class BonusServiceImpl implements BonusService {

    Logger LOG = LoggerFactory.getLogger(ClientServiceImpl.class);

    private BonusRepository bonusRepository;
    private UserRepository userRepository;

    @Autowired
    public BonusServiceImpl(BonusRepository bonusRepository, UserRepository userRepository) {
        this.bonusRepository = bonusRepository;
        this.userRepository = userRepository;
    }

    @Override
    public String create(String name, Double shareOfTransaction, String userUuid) {
        LOG.info("createBonus: "+shareOfTransaction);
        Bonus bonus = new Bonus();
        bonus.setName(name);
        bonus.setShareOfTransaction(shareOfTransaction);
        bonus.setUser(userRepository.findOneByUuid(userUuid));
        bonusRepository.save(bonus);
        return bonus.getUuid();
    }

    @Override
    public Set<BonusDto> findAll() {
        return bonusRepository.findAllBy().stream()
                .map(BonusDto::new)
                .collect(Collectors.toSet());
    }
}
