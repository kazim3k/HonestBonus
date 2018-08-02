package com.github.GroupProject.repository;

import com.github.GroupProject.entities.EBP;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface EBPRepository extends CrudRepository<EBP,Long> {
    EBP findOneByUuid(String ebpUuid);
    Set<EBP> findAllBy();
}
