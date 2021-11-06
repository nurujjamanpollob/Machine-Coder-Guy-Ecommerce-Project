/*
 * Copyright (c) 2021 Nurujjaman Pollob, All Right Reserved.
 *     Licensed under the Apache License, Version 2.0 (the "License");
 *     you may not use this file except in compliance with the License.
 *     You may obtain a copy of the License at
 *
 *           http://www.apache.org/licenses/LICENSE-2.0
 *
 *     Unless required by applicable law or agreed to in writing, software
 *     distributed under the License is distributed on an "AS IS" BASIS,
 *     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *     See the License for the specific language governing permissions and
 *     limitations under the License.
 *
 */

package com.nurujjamanpollob.machinecoderguy.backend.test;


import com.fasterxml.jackson.databind.util.ArrayIterator;
import com.nurujjamanpollob.machinecoderguystore.backend.users.UserRepository;
import com.nurujjamanpollob.machinecoderguystore.commonlibrary.Role;
import com.nurujjamanpollob.machinecoderguystore.commonlibrary.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@DataJpaTest
@ContextConfiguration(classes = {UserRepository.class})
@EnableJpaRepositories(basePackages = {"com.nurujjamanpollob.machinecoderguystore.backend.*"})
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@EntityScan({"com.nurujjamanpollob.machinecoderguystore.commonlibrary", "com.nurujjamanpollob.machinecoderguystore.backend.users"})
@ComponentScan(basePackages = {"com.nurujjamanpollob.machinecoderguystore.*"})
@Rollback(value = false)
public class UserRepositoryTests {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TestEntityManager entityManager;



    @Test
    public void createTestUserWithOneRole(){

        Role admin = entityManager.find(Role.class, 2);
        User userNurujjamanPollob = new User("nurujjamanpollob@gmail.com", "passcode", "Nurujjaman", "Pollob");
        userNurujjamanPollob.addRole(admin);
        User savedUser = userRepository.save(userNurujjamanPollob);
        assertThat(savedUser.getId()).isGreaterThan(0);

    }


    @Test
    public void createUserWithTwoRole(){

        User userVlad = new User("vlad@gmail.com", "passcode", "Vlad", "Sonkin");
        Role editor = new Role(2);
        Role assistant = new Role(5);

        userVlad.addRole(editor);
        userVlad.addRole(assistant);


        User savedUser = userRepository.save(userVlad);


        assertThat(savedUser.getId()).isGreaterThan(0);


    }


    @Test
    public void listAllUserFromDatabase(){


        Iterable<User> userList = userRepository.findAll();

        userList.forEach(System.out::println);

    }


    @Test
    public void testGetUserByID(){

        User admin = userRepository.findById(2L).isPresent() ? userRepository.findById(2L).get() : null;

        assertThat(admin).isNotNull();

    }



    @Test
    public void testUpdateUserDetails(){

        User admin = userRepository.findById(2L).isPresent() ? userRepository.findById(2L).get() : null;

        if (admin != null) {
            admin.setEnabled(true);
            admin.setEmail("user@domain.com");
            userRepository.save(admin);
        }



    }

    @Test
    public void testUpdateUserRole(){

        User vlad = userRepository.findById(2L).isPresent() ? userRepository.findById(2L).get() : null;

        if (vlad != null) {

            Role editor = new Role(2);

            Role salesPerson = new Role(4);

            vlad.getRoles().remove(editor);
            vlad.getRoles().add(salesPerson);

            userRepository.save(vlad);


        }



    }



    @Test
    public void testDeleteUserBasedOnID(){


        userRepository.deleteById(2L);



    }


    @Test
    public void testUserGetByEmail(){

        String email = "heeeeyyyyy@gmail.com";

       User user = userRepository.getUserByEmail(email);

       assertThat(user).isNull();

    }




    @Test
    public void testDisableUser(){

        userRepository.updateUserStatus(12L, false);

    }


    @Test
    public void testEnableUser(){

        userRepository.updateUserStatus(12L, true);

    }



}
