package com.github.GroupProject.repository;

import com.github.GroupProject.entities.Bonus;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BonusRepository extends CrudRepository<Bonus,Long> {

}
