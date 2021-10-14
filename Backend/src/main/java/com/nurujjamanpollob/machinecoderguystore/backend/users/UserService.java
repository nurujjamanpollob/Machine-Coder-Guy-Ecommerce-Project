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

package com.nurujjamanpollob.machinecoderguystore.backend.users;


import com.nurujjamanpollob.machinecoderguystore.commonlibrary.Role;
import com.nurujjamanpollob.machinecoderguystore.commonlibrary.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {


    // Spring Dependency with method level Injection
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;


    // return all user data as Array
    public List<User> getAllUser() {
        return (List<User>) userRepository.findAll();
    }


    //return all role data as array{name with description, id, etc}
    public List<Role> getAllRoles() {

        return (List<Role>) roleRepository.findAll();
    }

    /**
     * This method will be used to save newly created user
     *
     * @param user pass user object to save
     * @see UserRepository class for more information.
     */
    public void saveUser(User user) {
        // before save any user, we should save user password
        encodeUserPassword(user);

        userRepository.save(user);
    }


    /**
     * Replace user password with encoded one
     * Requires user Object
     *
     * @param user pass User object here.
     * @see org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder for more information on how password encoder works.
     */
    public void encodeUserPassword(User user) {


        // get current password and replace with encoded one
        user.setPassword(passwordEncoder.encode(user.getPassword()));
    }


    /**
     * 
     * @param email email address to query by
     * @return true if an existing matched with this email address, else false
     * @see UserRepository#getUserByEmail for more information.
     */
    public boolean isUserUniqueByEmail(String email){

        return userRepository.getUserByEmail(email) == null;
    }

}
