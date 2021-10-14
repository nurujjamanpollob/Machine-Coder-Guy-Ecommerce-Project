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

package com.nurujjamanpollob.machinecoderguystore.restcontroller;


import com.nurujjamanpollob.machinecoderguystore.backend.users.UserService;
import com.nurujjamanpollob.machinecoderguystore.restcontroller.extra.Variables;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Nurujjaman Pollob
 *
 * Rest Controller Class for User object and UserService Object
 *
 * @see com.nurujjamanpollob.machinecoderguystore.commonlibrary.User and
 * @see com.nurujjamanpollob.machinecoderguystore.backend.users.UserService for more information
 *
 */
@RestController
public class UserRestController {


    @Autowired
    private UserService userService;

    @PostMapping(com.nurujjamanpollob.machinecoderguystore.backend.utility.Variables.POST_USERS_CHECK_EMAIL)
    public String checkIfEmailIsDuplicated(@Param("email") String email){

        return userService.isUserUniqueByEmail(email) ? Variables.USER_EMAIL_NOT_DUPLICATED : Variables.USER_EMAIL_DUPLICATED;
    }



}
