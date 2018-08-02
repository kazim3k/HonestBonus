package com.github.GroupProject.repository;

import com.github.GroupProject.entities.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee,Long>{
    Employee findOneByUuid(String employeeUuid);

    Set<Employee> findAllBy ();

}


