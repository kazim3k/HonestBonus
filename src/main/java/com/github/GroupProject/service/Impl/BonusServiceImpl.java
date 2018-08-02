package com.github.GroupProject.service.Impl;

import com.github.GroupProject.entities.Bonus;
import com.github.GroupProject.repository.BonusRepository;
import com.github.GroupProject.repository.UserRepository;
import com.github.GroupProject.service.BonusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BonusServiceImpl implements BonusService {

    private BonusRepository bonusRepository;
    private UserRepository userRepository;

    @Autowired
    public BonusServiceImpl(BonusRepository bonusRepository, UserRepository userRepository) {
        this.bonusRepository = bonusRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void create(String name, Double shareOfTransaction, String userUuid) {
        Bonus bonus = new Bonus();
        bonus.setName(name);
        bonus.setPercentOfTransaction(shareOfTransaction);
        bonus.setUser(userRepository.findOneByUuid(userUuid));
        bonusRepository.save(bonus);
    }
}
