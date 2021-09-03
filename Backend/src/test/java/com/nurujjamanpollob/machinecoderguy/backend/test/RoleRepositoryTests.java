package com.nurujjamanpollob.machinecoderguy.backend.test;

import com.nurujjamanpollob.machinecoderguystore.backend.users.RoleRepository;
import com.nurujjamanpollob.machinecoderguystore.commonlibrary.Role;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.annotation.Rollback;
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
@EntityScan({"com.nurujjamanpollob.machinecoderguystore.commonlibrary", "com.nurujjamanpollob.machinecoderguystore.backend.users"})
@ComponentScan(basePackages = { "com.nurujjamanpollob.machinecoderguystore.*" })
@Rollback(value = false)
public class RoleRepositoryTests {

    @Autowired
    private RoleRepository repository;

    // create first test! yeeehoo!!!
    @Test
    public void createAdminTest(){

        // create test for admin role
        Role adminRole = new Role("Admin", "The admin is can manage everything");

        // save newly created data to database and assign to new object
        Role role =repository.save(adminRole);

        //try to check if data is not null!
        assertThat(role.getRoleID()).isGreaterThan(0);


    }


    @Test
    public void createSalesPersonRoleTest(){

        // create test for sales person role
        Role salesPersonRole = new Role("Salesperson", "Manage product price" +
                ", customers, shipping, order & sales report");






        // save newly created data to database and assign to new object
        Role role =repository.save(salesPersonRole);

        //try to check if data is not null!
        assertThat(role.getRoleName()).isNotNull();


    }



    @Test
    public void createEditorRoleTest(){


        // create a new role for editor
        Role editorRole = new Role("Editor", "Manage categories" +
                ", brands, products, articles & menus");

        // save newly created data to database and assign to new object
        Role role =repository.save(editorRole);

        //try to check if data is not null!
        assertThat(role.getRoleName()).isNotNull();

    }



    @Test
    public void createShipperRoleTest(){


        // create a new role for shipper
        Role shipperRole = new Role("Shipper", "View products" +
                ", View Order, update order Status");

        // save newly created data to database and assign to new object
        Role role =repository.save(shipperRole);

        //try to check if data is not null!
        assertThat(role.getRoleName()).isNotNull();

    }

    @Test
    public void createAssistantRoleTest(){


        // create a new role for shipper
        Role assistantRole = new Role("Assistant", "Manage questions" +
                "and reviews of product");

        // save newly created data to database and assign to new object
        Role role =repository.save(assistantRole);

        //try to check if data is not null!
        assertThat(role.getRoleName()).isNotNull();

    }


}
