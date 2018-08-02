package com.github.GroupProject.repository;

import com.github.GroupProject.entities.Client;
import com.github.GroupProject.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface UserRepository extends CrudRepository<User,Long> {
    User findOneByUuid(String userUuid);

    Set<User> findAllBy();
}
