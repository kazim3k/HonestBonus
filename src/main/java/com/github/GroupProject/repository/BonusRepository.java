package com.github.GroupProject.repository;

import com.github.GroupProject.entities.Bonus;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface BonusRepository extends CrudRepository<Bonus,Long> {

    Bonus findOneByUuid(String bonusUuid);

    Set<Bonus> findAllBy();
}
