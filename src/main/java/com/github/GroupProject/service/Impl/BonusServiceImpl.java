package com.github.GroupProject.service.Impl;

import com.github.GroupProject.dto.BonusDto;
import com.github.GroupProject.entities.Bonus;
import com.github.GroupProject.repository.BonusRepository;
import com.github.GroupProject.repository.UserRepository;
import com.github.GroupProject.service.BonusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

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
        bonus.setShareOfTransaction(shareOfTransaction);
        bonus.setUser(userRepository.findOneByUuid(userUuid));
        bonusRepository.save(bonus);
    }

    @Override
    public Set<BonusDto> findAll() {
        return bonusRepository.findAllBy().stream()
                .map(BonusDto::new)
                .collect(Collectors.toSet());
    }
}
