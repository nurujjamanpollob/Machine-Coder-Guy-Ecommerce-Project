package com.nurujjamanpollob.machinecoderguy.backend.test;

import com.nurujjamanpollob.machinecoderguystore.backend.users.RoleRepository;
import com.nurujjamanpollob.machinecoderguystore.commonlibrary.Role;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.ContextConfiguration;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest

/*
  To wipe out "Could not autowire. No beans of 'RoleRepository' type found."
  We are defining @ContextConfiguration with desires class name
 */
@ContextConfiguration(classes = {RoleRepository.class})
@EnableJpaRepositories(basePackages = {"com.nurujjamanpollob.machinecoderguystore.backend.*"})
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class RoleRepositoryTests {

    @Autowired
    private RoleRepository repository;

    // create first test! yeeehoo!!!
    @Test
    public void createFirstTest(){

        // create test for admin role
        Role adminRole = new Role("Admin", "The admin is can manage everything");

        // save newly created data to database and assign to new object
        Role role =repository.save(adminRole);

        //try to check if data is not null!
        assertThat(role.getRoleID()).isGreaterThan(0);


    }
}
