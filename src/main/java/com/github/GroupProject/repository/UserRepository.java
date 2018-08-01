package com.github.GroupProject.repository;

import com.github.GroupProject.entities.Client;
import com.github.GroupProject.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User,Long> {
    User findOneByUuid(String uuid);
}
