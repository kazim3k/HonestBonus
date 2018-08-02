package com.github.GroupProject.repository;

import com.github.GroupProject.entities.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee,Long>{
    Employee findOneByUuid(String employeeUuid);
}
