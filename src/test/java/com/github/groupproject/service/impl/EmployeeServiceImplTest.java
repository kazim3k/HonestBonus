package com.github.groupproject.service.impl;

import com.github.groupproject.entities.Employee;
import com.github.groupproject.repository.EmployeeRepository;
import com.github.groupproject.repository.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class EmployeeServiceImplTest {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private UserRepository userRepository;

    @Test
    public void whenCreatingEmployee_ThenEmployeeExists() {
        EmployeeServiceImpl employeeService = new EmployeeServiceImpl(userRepository, employeeRepository);
        UserServiceImpl userService = new UserServiceImpl(userRepository);

        String userUuid = userService.create("Brand24","bran@24.pl");
        String employeeUuid = employeeService.create("Michal","Kowalski",
                "kowalski@24.pl",userUuid);

        Employee employee = employeeRepository.findOneByUuid(employeeUuid);
        Assertions.assertThat(employee)
                .isNotNull()
                .hasFieldOrPropertyWithValue("firstName", "Michal")
                .hasFieldOrPropertyWithValue("lastName", "Kowalski")
                .hasFieldOrPropertyWithValue("email", "kowalski@24.pl")
                .hasFieldOrPropertyWithValue("user",userRepository.findOneByUuid(userUuid));
    }
}
