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

package com.nurujjamanpollob.machinecoderguystore.commonlibrary;

import com.nurujjamanpollob.machinecoderguystore.commonlibrary.utilities.Variables;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;


/**
 * @author Nurujjaman Pollob
 * <p>
 * This class is responsible for create and hold user role values.
 */
@Entity
@Table(name = Variables.DATABASE_TABLE_NAME_ROLES)
@SuppressWarnings({"UnusedDeclaration"})
public class Role {


    /**
     * @param roleName        pass desired role name
     * @param roleDescription you can pass role description here, for reference a role with administrative purposes
     *                        Pass meaningful description to make sense :D
     */

    public Role(String roleName, String roleDescription) {

        this.name = roleName;
        this.description = roleDescription;
    }

    /**
     * @param roleName pass desired role name
     *                 It is recommended that do not pass hardcoded String
     */
    public Role(String roleName) {

        this.name = roleName;
    }

    /**
     * Role class without any constructor parameter
     */
    public Role() {

    }

    /**
     * @param id pass an integer value, if you already have added roles data in database, simply passing
     *           Their index will automatically assign a role for this user.
     */
    public Role(int id) {

        this.id = id;

    }

    //create field of role id and generate id in database
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    //create field of role name and assign it to column with various params
    @Column(name = Variables.DATABASE_COLUMN_ROLE_KEY_NAME, length = 40, nullable = false, unique = true)
    private String name;

    //create field of role description assign it to column with various parameter
    @Column(name = Variables.DATABASE_COLUMN_ROLE_KEY_DESCRIPTION, length = 250, nullable = false)
    private String description;

    /**
     * @return id for an input role. This is useful if you know the role name but do not know more about
     * its Identity value
     */
    public Integer getRoleID() {

        return id;
    }

    /**
     * @param id pass an integer value for assign a integer value to a individual role.
     */
    public void setRoleID(Integer id) {

        this.id = id;
    }

    /**
     * @return Role Name simply by its instance
     * If the constructor parameter is null, it may pass a null String.
     */
    public String getRoleName() {

        return name;
    }

    /**
     * @param name pass String to set role name respectively
     *             It is recommended that do not pass hardcoded value.
     */
    public void setRoleName(String name) {

        this.name = name;
    }

    /**
     * @return null if Role object is null
     * Else, it will return role description from Role Object
     */
    public String getRoleDescription() {

        return description;
    }

    /**
     * @param roleDescription pass a String to set Role Description.
     */
    public void setRoleDescription(String roleDescription) {

        this.description = roleDescription;
    }


    /**
     * @param objectInstance pass object instance to compare with Role instance
     * @return true if Role and Object is same, else return false.
     */
    @Override
    public boolean equals(Object objectInstance) {

        // if Role equals object, then we simply return true
        if (this == objectInstance) return true;

        // if object null or Role class is not match with Object class return false simply
        if (objectInstance == null || getClass() != objectInstance.getClass()) return false;

        // create a role object from Object
        Role role = (Role) objectInstance;

        // return true if newly created Role object id matches with current object Identity
        // hence false.
        return Objects.equals(id, role.id);

    }

    /**
     * @return Integer of Role object identity Hash Code if Role object id is not null
     * else, return 0!
     */
    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }


    /**
     * @return Role object in String format
     * Currently we are passing the role name only
     */
    @Override
    public String toString() {
        return this.name;
    }
}
