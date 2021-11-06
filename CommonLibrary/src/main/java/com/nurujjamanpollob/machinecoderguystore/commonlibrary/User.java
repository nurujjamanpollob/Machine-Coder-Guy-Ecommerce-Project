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

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = Variables.DATABASE_TABLE_NAME_USERS)
@SuppressWarnings({"UnusedDeclaration"})
public class User {

    public User() {

    }

    public User(String email, String password, String firstName, String lastName) {
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = Variables.DATABASE_COLUMN_USERS_EMAIL_ADDRESS, length = 128, nullable = false, unique = true)
    private String email;

    @Column(name = Variables.DATABASE_COLUMN_USERS_PASSWORD, length = 64, nullable = false)
    private String password;

    @Column(name = Variables.DATABASE_COLUMN_USERS_FIRST_NAME, length = 16, nullable = false)
    private String firstName;

    @Column(name = Variables.DATABASE_COLUMN_USERS_LAST_NAME, length = 16, nullable = false)
    private String lastName;

    @Column(name = Variables.DATABASE_COLUMN_USERS_PHOTO, length = 150)
    private String photo;

    private boolean enabled;




    // create roles set
    @ManyToMany
    @JoinTable(

            name = Variables.DATABASE_TABLE_NAME_USER_ROLES,
            joinColumns = @JoinColumn(name = Variables.DATABASE_TABLE_NAME_USER_ROLES_COLUMN_ID),
            inverseJoinColumns = @JoinColumn(name = Variables.DATABASE_TABLE_NAME_USER_ROLES_COLUMN_INVERSE)

    )
    private Set<Role> roles = new HashSet<>();


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public void addRole(Role role) {

        this.roles.add(role);

    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", photo='" + photo + '\'' +
                ", enabled=" + enabled +
                ", roles=" + roles +
                '}';
    }



    @Transient
    public String getUserImagePath(){

        // if user image is not present, or creating new user
        if(this.id == null || this.photo == null)
            return Variables.APPLICATION_CONTEXT_PATH + "images/sample-user-photo.png";
        return Variables.APPLICATION_CONTEXT_PATH + "user-files/" + this.id + "/avatar/" + this.photo;
    }
}
