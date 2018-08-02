package com.github.GroupProject.repository;

import com.github.GroupProject.entities.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends CrudRepository<Client,Long> {
    Client findOneByUuid(String clientUuid);

}
