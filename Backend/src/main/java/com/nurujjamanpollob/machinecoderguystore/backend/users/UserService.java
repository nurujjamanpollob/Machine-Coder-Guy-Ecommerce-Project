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


import com.nurujjamanpollob.machinecoderguystore.backend.exception.UserNotFoundException;
import com.nurujjamanpollob.machinecoderguystore.commonlibrary.Role;
import com.nurujjamanpollob.machinecoderguystore.commonlibrary.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * @author Nurujjaman Pollob
 * Service class for User Entity
 */
@Service
@Transactional
public class UserService {




    private final UserRepository userRepository;
    private final RoleRepository roleRepository;


    /**
     * @param userRepository get Spring framework injected bean of UserRepository class
     * @param roleRepository get Spring framework injected bean of RoleRepository class
     * @see UserRepository class and
     * @see RoleRepository class for more information
     */
    public UserService(UserRepository userRepository, RoleRepository roleRepository){

        this.roleRepository = roleRepository;
        this.userRepository = userRepository;


    }


    /**
     * Get all user data as Array
     * @return list of users is exists in database.
     */
    public List<User> getAllUser() {
        return (List<User>) userRepository.findAll();
    }


    /**
     * Get list of roles.
     * @return A list of roles that exists in database file.
     */

    public List<Role> getAllRoles() {

        return (List<Role>) roleRepository.findAll();
    }

    /**
     * This method will be used to save bot newly created / existing user
     * @param user pass user object to save
     * @see UserRepository class for more information.
     * @return saved user object.
     */
    public User saveUser(User user) {

        if(user.getId() != null) {
            //get existing user
            User existingUser = null;
            if (userRepository.findById(user.getId()).isPresent()) {
                existingUser = userRepository.findById(user.getId()).get();
            }
            if(user.getPassword().isEmpty() || user.getPassword().isBlank()){
                user.setPassword(existingUser != null ? existingUser.getPassword() : null);
            }

        }
       return userRepository.saveUserWithEncryptedPassword(user);

    }

    /**
     * @param email email address to query by
     * @return true if an existing matched with this email address, else false
     * @see UserRepository#getUserByEmail for more information.
     */

    public boolean isUserUniqueByEmail(@Nullable Integer id, String email){

        User user = userRepository.getUserByEmail(email);

        if (user == null) return true;
        if (id == null) return false;
        return userRepository.getUserByEmail(email).getId() == id.longValue();
    }


    /**
     * @param id User id get a user object
     * @return a User that associated with given Identity
     * @throws UserNotFoundException if the User not found in the Database
     */
    public User getUserById(Long id) throws UserNotFoundException {

            if(userRepository.findById(id).isPresent()){

               return userRepository.findById(id).get();

            }else {
                throw new UserNotFoundException("User not found for given ID: "+id);

            }

    }


    /**
     * @param id delete a user by Given ID
     * @throws UserNotFoundException if the User object is not found in database.
     */
    public void deleteUserById(Long id) throws UserNotFoundException {

        if(userRepository.findById(id).isPresent()){

            userRepository.deleteById(id);
        }else {

            throw new UserNotFoundException("User not found for given ID: "+id);
        }

    }


    /**
     * @param id Updated user status by Given ID
     * @param status Status to pass, simple (true / false)
     */
    public void updateUserStatus(Long id, boolean status){

        userRepository.updateUserStatus(id, status);
    }

}
