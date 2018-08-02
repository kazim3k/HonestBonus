package com.github.groupproject.service.impl;

import com.github.groupproject.entities.Bonus;
import com.github.groupproject.repository.BonusRepository;
import com.github.groupproject.repository.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class BonusServiceImplTest {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BonusRepository bonusRepository;

    @Test
    public void whenCreatingBonus_ThenBonusExist() {

        UserServiceImpl userService = new UserServiceImpl(userRepository);
        BonusServiceImpl bonusService = new BonusServiceImpl(bonusRepository, userRepository);

        String userUuid = userService.create("Brand24","bran@24.pl");
        String bonustUuid = bonusService.create("1 kontakt",0.05,userUuid);


        Bonus bonus = bonusRepository.findOneByUuid(bonustUuid);
        Assertions.assertThat(bonus)
                .isNotNull()
                .hasFieldOrPropertyWithValue("name","1 kontakt")
                .hasFieldOrPropertyWithValue("shareOfTransaction",0.05)
                .hasFieldOrPropertyWithValue("user",userRepository.findOneByUuid(userUuid));





    }
}
