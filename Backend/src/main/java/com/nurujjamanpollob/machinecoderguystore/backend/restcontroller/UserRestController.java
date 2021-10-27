/*
 * Copyright (c) 2021-2021 Nurujjaman Pollob, All Right Reserved.
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

package com.nurujjamanpollob.machinecoderguystore.backend.restcontroller;


import com.nurujjamanpollob.machinecoderguystore.backend.users.UserService;
import com.nurujjamanpollob.machinecoderguystore.backend.utility.Variables;
import com.nurujjamanpollob.machinecoderguystore.commonlibrary.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

/**
 * @author Nurujjaman Pollob
 * <p>
 * Rest Controller Class for User object and UserService Object
 * @see com.nurujjamanpollob.machinecoderguystore.commonlibrary.User and
 * @see com.nurujjamanpollob.machinecoderguystore.backend.users.UserService for more information
 */
@RestController
public class UserRestController {


    @Autowired
    private UserService userService;



    /**
     * This method respond to this GET request in following URL: $SERVER_URL/users/check_email
     *
     * @param email request parameter
     * @return OK if email has no match in database, else it returns DUPLICATED
     */

    @GetMapping(Variables.GET_USERS_CHECK_EMAIL)
    @ResponseBody
    public String checkIfEmailIsUnique(@RequestParam(name = "email") String email, @Nullable @RequestParam(name = "id", required = false) Integer id ) {

        return userService.isUserUniqueByEmail(id, email) ? Variables.USER_EMAIL_NOT_DUPLICATED : Variables.USER_EMAIL_DUPLICATED;

    }


}
