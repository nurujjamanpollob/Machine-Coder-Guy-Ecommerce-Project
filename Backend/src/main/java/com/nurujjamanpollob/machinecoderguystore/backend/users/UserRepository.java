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

import com.nurujjamanpollob.machinecoderguystore.commonlibrary.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author Nurujjaman Pollob
 * Inherited CRUD repository class for User entity
 * @see org.springframework.data.repository.CrudRepository for more information
 */
@SuppressWarnings({"UnusedDeclaration"})
public interface UserRepository extends CrudRepository<User, Long> {


    /**
     * query user by email
     * @return a User object if lookup has found a match
     * Else, it will return a null object.
     * @see Query class for more information
      */
    @Query("SELECT u FROM User u WHERE u.email = :email")
    User getUserByEmail(@Param("email") String email);

    /**
     * @param user Passed user object to encrypt Password
     * @return an Associated User object with encrypted password.
     */
    default User saveUserWithEncryptedPassword(User user){
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
       return save(user);

    }

    /**
     * Method to Query and update user status
     * @param id User ID to find a User Object
     * @param enabled set User status
     * @see Query and
     * @see Modifying class for more information
     */
    @Query("UPDATE User u set u.enabled = ?2 where u.id = ?1")
    @Modifying
    void updateUserStatus(Long id, boolean enabled);
}
